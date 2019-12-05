package doan.controller;
import java.io.File;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;

import do_an.bean.Xmailler;
import do_an.entity.Category;
import do_an.entity.Comment;
import do_an.entity.Genre;
import do_an.entity.Movie;
import do_an.entity.Request;
import do_an.entity.User;
import do_an.entity.UserType;

@Transactional
@Controller
@RequestMapping("/main/")
public class LoginRegisterController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(ModelMap model){
		model.addAttribute("user",new User());
		return "main/login";
	}
	public User getUser(User user_get){
		User return_user= user_get;
		return return_user;
	}
	User user_get; // User này là kết quả của Query theo username và password
	String username_get;
												/*Login*/
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(ModelMap model,@Validated @ModelAttribute("user")User user,BindingResult errors){
		Session session= factory.getCurrentSession();
		
		
		String hql="From User u Where u.username  =:varA AND u.password =:varB";
		Query query= session.createQuery(hql);
		query.setString("varA",user.getUsername());
		query.setString("varB",user.getPassword());
		List<User> list_user= query.list();
			if(!list_user.isEmpty()){
					if(list_user.get(0).getAdministrator()==true){
						user_get=getUser(list_user.get(0));
						username_get=list_user.get(0).getUsername();
						return "redirect:/main/index_admin.htm";
					}else{
						if(list_user.get(0).getUser_type().getType_id().equals("t01")){
							user_get=getUser(list_user.get(0));
							username_get=list_user.get(0).getUsername();
							return "redirect:/main/index_standard.htm";
						}else if(list_user.get(0).getUser_type().getType_id().equals("t02")){
							user_get=getUser(list_user.get(0));
							username_get=list_user.get(0).getUsername();
							return "redirect:/main/index_vip.htm";
						}
					}
					
			}else{
				errors.rejectValue("password","user","Wrong Username or Password !!!");
			}
		return "main/login";
	}
	 										//lấy username_get cho modelAttribute về sau 
	@ModelAttribute("username") 
	public String username_get(){
		String username_get_use= username_get;
		return username_get_use;
	}
											//Đăng nhập thành công với username để trả về trang chính xin chào
	
	@RequestMapping(value="index_standard")
	public String index_standard(ModelMap model){
		
		return "main/index_standard";
	}
											//TV_SHOW
	public List<Movie> TaoListPhimChoTrangHienThi(String b){
		Session session=factory.getCurrentSession();
		String hql="FROM Movie WHERE genre.id = :varB ";
		Query query=session.createQuery(hql);
		
		query.setParameter("varB",b);
		List<Movie>list=query.list();
		return list;
	}
	@RequestMapping("tv_show")
	public String tv_show(ModelMap model){
		model.addAttribute("user",user_get);
		List<Movie> list_tv_show=TaoListPhimChoTrangHienThi("g01");
		model.addAttribute("list_tv_show",list_tv_show);
		return "main/tv_show";
	}
											//Features
	@RequestMapping("phim_le")
	public String phim_le(ModelMap model){
		model.addAttribute("user",user_get);
		List<Movie> list_features=TaoListPhimChoTrangHienThi("g02");
		model.addAttribute("list_features", list_features);
		return "main/phim_le";
	}
											//Detail Page
	
	@RequestMapping(value="detail_page/{movie_id}",method=RequestMethod.GET)
	public String detail_page(ModelMap model,@PathVariable("movie_id")Integer movie_id,@ModelAttribute("user")User user){
		Session session=factory.getCurrentSession();
		String hql="FROM Movie m WHERE movie_id = :varA";
		Query query=session.createQuery(hql);
		query.setParameter("varA",movie_id);
		
		List<Movie>list=query.list();	
		model.addAttribute("movie",list.get(0));
		model.addAttribute("movie_id",movie_id);
		final Movie movie_get=list.get(0);
		
		Session session_guests=factory.getCurrentSession();
		String hql2="FROM Movie WHERE genre =:varB";
		Query query2= session_guests.createQuery(hql2);
		
		query2.setParameter("varB",movie_get.getGenre());	
		List<Movie>list_movies= query2.list();
		Collections.shuffle(list_movies);
		model.addAttribute("list_movies",list_movies);
		model.addAttribute("user",user_get);
		model.addAttribute("comment", new Comment());
		
		Session session_show_comments=factory.getCurrentSession();
		String hql3="FROM Comment WHERE movie.movie_id = :varA";
		Query query3=session_show_comments.createQuery(hql3);
		query3.setParameter("varA",movie_id);
		List<Comment>list_comments=query3.list();
		model.addAttribute("list_comments",list_comments);
		
		return "main/detail_page";
	}
	@RequestMapping(value="detail_page/{movie_id}",method=RequestMethod.POST)
	public String detail_page(ModelMap model,@PathVariable("movie_id")Integer movie_id,
							@ModelAttribute("comment")Comment comment,BindingResult errors,
							@ModelAttribute("user")User user,@ModelAttribute("movie")Movie movie
							)
	{
		if(comment.getContent().trim().length() <3){
			errors.rejectValue("content","comment","YOU ARE A SPAMMER !!!");
		}
			
					Session session=factory.openSession();
					Transaction t= session.beginTransaction();
					comment.setUser(user_get);
					comment.setMovie(movie);
			try{
				session.save(comment);
				t.commit();
				return "redirect:/main/detail_page/{movie_id}.htm";
			}catch(Exception e){
				t.rollback();
				
				
			}finally{
				session.close();
			}
			
		return "main/detail_page";
	}
	
											//Index_vip
	@RequestMapping(value="index_vip")
	public String index_vip(ModelMap model){
		
		return "main/index_vip";
	}
	
														//GetAll User_types
	@ModelAttribute("user_types")
	public List<UserType> getAllUserType(){
		
		Session session_guests=factory.getCurrentSession();
		String hql="From UserType";
		
		Query query= session_guests.createQuery(hql);
		
		List<UserType> list_user_type= query.list();
		return list_user_type;
	}
													//Register
		public Boolean CheckUsernameExist(String a){
			Session session= factory.getCurrentSession();
			
			Boolean check_kq=false;
				String hql="Select username From User";
				Query query= session.createQuery(hql);
				List<String> list_username= query.list();
					for(int i=0;i<list_username.size();i++){
						if(list_username.get(i).equals(a)){
							check_kq=true;
							break;
						}
					}
			return check_kq;
		}
		@RequestMapping(value="register",method=RequestMethod.GET)
		public String register(ModelMap model){
			model.addAttribute("user",new User());
			return "main/register";
		}
		@RequestMapping(value="register",method=RequestMethod.POST)
		public String register(ModelMap model,@Validated @ModelAttribute("user")User user,BindingResult errors,@RequestParam(value="retype_password",defaultValue="")String retype_password){
			user.setAdministrator(false);	
			if(CheckUsernameExist(user.getUsername())==true){
					errors.rejectValue("username","user","Username Existed !!!");
				}
				if(!user.getPassword().equals(retype_password)){
					errors.rejectValue("password","user","Confirm password is differ with password !!!");
				}
				if(errors.hasErrors()){
					model.addAttribute("message","Bạn đang mắc các lỗi sau: ");
					return "main/register";
				}
					Session session= factory.openSession();
					Transaction t= session.beginTransaction();
						try {
							session.save(user);
							t.commit();
							return "redirect:/main/login.htm";
						} catch (Exception e) {
							t.rollback();
						}finally {
							session.close();
						}
			return "main/register";
		}
													// Show information User
	@RequestMapping(value="show_information_user/{username}")
	public String show_information_user(ModelMap model,@PathVariable("username")String username){
		model.addAttribute("user",user_get);
		return "main/show_information_user";
	}
	
													//Update User
	@RequestMapping(value="update_user/{username}",method=RequestMethod.GET)
	public String update_user(ModelMap model,@PathVariable("username")String username){
		
		model.addAttribute("user",user_get);
		return "main/update_user";
	}
	@RequestMapping(value="update_user/{username}",method=RequestMethod.POST)
	public String update_user(ModelMap model,@Validated @ModelAttribute("user")User user,
								@PathVariable("username")String username,
								@RequestParam("avatar")MultipartFile avatar,BindingResult errors){
		List<String>contentTypes= Arrays.asList("image/PNG","image/png","image/jpg","image/JPG","image/JPEG","image/jpeg");
		String avatarType=avatar.getContentType();
				if(!contentTypes.contains(avatarType)){
					model.addAttribute("error_update_avatar","Your file type is invalid !");
				}
				if(avatar.isEmpty()){
					model.addAttribute("error_update_avatar","You haven't updated your avatar yet !");
					
				}
				user.setUsername(user_get.getUsername());
				user.setPassword(user_get.getPassword());
				user.setAdministrator(user_get.getAdministrator());
						if(user.getName_of_user().trim().length()==0){
							errors.rejectValue("name_of_user","user","Name not null");
						}
					if(errors.hasErrors()){
						model.addAttribute("message","Bạn vi phạm các lỗi sau");
						return "main/update_user";
					}
					Session session= factory.openSession();
					Transaction t= session.beginTransaction();
					try {
						String path= "E:\\hoc java\\DoAn\\WebContent\\resources\\images\\user\\"+avatar.getOriginalFilename();
						avatar.transferTo(new File(path));
						user.setImage_avatar("/DoAn/resources/images/user/"+avatar.getOriginalFilename());
						session.update(user);
						t.commit();
						return "main/show_information_user";
						
					} catch (Exception e) {
						t.rollback();
					}finally {
						session.close();
					}
		return "main/update_user";
	}
												
												//Feedback
	@Autowired
	Xmailler mailer;
	@RequestMapping(value="feedback",method=RequestMethod.GET)
	public String feedback(ModelMap model){
		
		return "main/feedback";
	}
	@Autowired
	ServletContext context;
	@RequestMapping(value="feedback",method=RequestMethod.POST)
	public String feedback(ModelMap model,@RequestParam("name") String name,
			@RequestParam("email")String email,@RequestParam("feedback")String feedback){
		Boolean errors=false;
		if(name.trim().length()==0){
			model.addAttribute("name_error", "You haven't show us your name yet !");
			errors=true;
		}
		if(email.trim().length()==0){
			model.addAttribute("email_error", "You haven't show us your email yet !");
			errors=true;
		}
		if(feedback.trim().length()==0){
				model.addAttribute("feedback_error", "You haven't show us your feedback yet !");
				errors=true;
			}
		if(errors==false){
			try{
				mailer.send(email, name, feedback);
				model.addAttribute("message","Send feedback succeeded!");
			}catch(Exception ex){
				
			}
		}else{
			model.addAttribute("message","Send Feedback Failed !");
		}
		return "main/feedback";
	}
	
	@RequestMapping(value="request_movie/{username}",method=RequestMethod.GET)
	public String request_movie(ModelMap model,@PathVariable("username")String username){
		
		model.addAttribute("request",new Request());
		return "main/request_movie";
	}
	@RequestMapping(value="request_movie/{username}",method=RequestMethod.POST)
	public String request_movie(ModelMap model,@Validated @ModelAttribute("request")Request request,BindingResult errors,@PathVariable("username")String username,
								@RequestParam("avatar") MultipartFile avatar){
		
			List<String>contentTypes= Arrays.asList("image/PNG","image/png","image/jpg","image/JPG","image/JPEG","image/jpeg");
		String avatarType=avatar.getContentType();
				if(!contentTypes.contains(avatarType)){
					errors.rejectValue("movie_avatar","request","You are not uploading an image");
				}
		Session session=factory.openSession();
		Transaction t= session.beginTransaction();
		request.setUser(user_get);
			try {
				
				String path = "E:\\hoc java\\DoAn\\WebContent\\resources\\images\\avatar_request\\" + avatar.getOriginalFilename();
				avatar.transferTo(new File(path));
				request.setMovie_avatar("/DoAn/resources/images/avatar_request/" +avatar.getOriginalFilename());
				model.addAttribute("photo_name",avatar.getOriginalFilename());
				session.save(request);
				t.commit();
					return "main/show_request_information";
				
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message","Error send request");
			}finally {
				session.close();
			}
		
		return "main/request_movie";
	}
	
																//Show_list_request
	
	@RequestMapping(value="show_list_request")
	public String show_list_request(ModelMap model){
		Session session=factory.getCurrentSession();
		String hql="FROM Request";
		Query query=session.createQuery(hql);
		List<Request>list=query.list();
		model.addAttribute("requests",list);
		return "main/show_list_request";
	}
																//Delete_request
	@RequestMapping(value="delete_request/{request_id}")
	public String delete_request(ModelMap model, @ModelAttribute("request")Request request,@PathVariable("request_id")Integer request_id){
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try{
			session.delete(request);
			t.commit();
			return "main/show_list_request";
		}catch(Exception e){
			t.rollback();
			model.addAttribute("message","Xóa mới thất bại");
			
		}finally{
			session.close();
		}
		return "main/show_list_request";
	}
															//show_request_information
	@RequestMapping(value="show_request_information")
	public String show_request_information(ModelMap model){
		model.addAttribute("request",new Request());
		return "main/show_request_information";
	}
	@ModelAttribute("categories")
	public List<Category> getAllCategories(){
		
		Session session_guests=factory.getCurrentSession();
		String hql="From Category";
		
		Query query= session_guests.createQuery(hql);
		
		List<Category> list_category= query.list();
		return list_category;
	}
	@RequestMapping(value="show_request_information",method=RequestMethod.POST)
	public String show_request_information(ModelMap model,@ModelAttribute("request")Request request,@ModelAttribute("user")User user){
		return "main/request";
	}
	
														//index_admin
	@RequestMapping(value="index_admin")
	public String index_admin(ModelMap model)
	{
		Session session_user=factory.getCurrentSession();
		String hql="From User u WHERE u.administrator = false";
		Query query= session_user.createQuery(hql);
		List<User> list_user= query.list();
		model.addAttribute("count_number_of_user",list_user.size());
		
		Session session_movie=factory.getCurrentSession();
		String hql2="From Movie ";
		Query query2= session_movie.createQuery(hql2);
		List<Movie> list_movie= query2.list();
		model.addAttribute("count_number_of_movie",list_movie.size());
		
		Session session_request=factory.getCurrentSession();
		String hql3="From Request ";
		Query query3= session_movie.createQuery(hql3);
		List<Request> list_request= query3.list();
		model.addAttribute("count_number_of_request",list_request.size());
		
		return "main/index_admin";
	}
	
															//Show_list_user
	@RequestMapping(value="show_list_user")
	public String show_list_user(ModelMap model){
		Session session=factory.getCurrentSession();
		String hql="FROM User";
		Query query=session.createQuery(hql);
		List<User>list=query.list();
		model.addAttribute("users",list);
		return "main/show_list_user";
	}
	
	@RequestMapping(value="delete_user/{username}")
	public String delete_user(ModelMap model,@PathVariable("username") String username,@ModelAttribute("user")User user){
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try{
			session.delete(user);
			t.commit();
			return "redirect:/main/show_list_user.htm";
		}catch(Exception e){
			t.rollback();
			model.addAttribute("message","Xóa mới thất bại");
			
		}finally{
			session.close();
		}
		return "main/show_list_user";
	}
	
															//Show_list_movie
	
	@RequestMapping(value="show_list_movie")
	public String show_list_movie(ModelMap model){
		Session session=factory.getCurrentSession();
		String hql="FROM Movie";
		Query query=session.createQuery(hql);
		List<Movie>list=query.list();
		model.addAttribute("movies",list);
		return "main/show_list_movie";
	}
	
															//insert_movie
	@RequestMapping(value="insert_movie/{request_id}")
	public String insert_movie_by_request(ModelMap model,@PathVariable("request_id") Integer request_id){
		Session session=factory.getCurrentSession();
		String hql="FROM Request WHERE request_id =:varA";
		Query query=session.createQuery(hql);
		query.setParameter("varA",request_id);
		List<Request>list=query.list();
		Request request_get=list.get(0);
		Movie movie_transfer_from_request= new Movie();
		movie_transfer_from_request.setMovie_name(request_get.getMovie_name());
		movie_transfer_from_request.setCategory(request_get.getCategory());
		movie_transfer_from_request.setIntroduction(request_get.getIntroduction());
		movie_transfer_from_request.setMovie_avatar_image(request_get.getMovie_avatar());
		model.addAttribute("movie",movie_transfer_from_request);
		
		return "main/insert_movie";
	}
		
	@RequestMapping(value="insert_movie",method=RequestMethod.GET)
	public String insert_movie(ModelMap model){
		
		
		model.addAttribute("movie",new Movie());
		return "main/insert_movie";
	}
													//GetAllGenre
	@ModelAttribute("genres")
	public List<Genre> getAllGenres(){
		
		Session session_genre=factory.getCurrentSession();
		String hql="From Genre";
		
		Query query= session_genre.createQuery(hql);
		
		List<Genre> list_genre= query.list();
		return list_genre;
	}
	public Boolean CheckMovieExist(Movie a){
		Boolean check=false;
		Session session_genre=factory.getCurrentSession();
		String hql="From Movie";
		
		Query query= session_genre.createQuery(hql);
		
		List<Movie> list_name_movie= query.list();
			if(list_name_movie.contains(a));
				check=true;
		return check;
	}
	
	@RequestMapping(value="insert_movie",method=RequestMethod.POST)
	public String insert_movie(ModelMap model,@Validated @ModelAttribute("movie")Movie movie,BindingResult errors,
								@RequestParam("avatar") MultipartFile avatar,@RequestParam("slider_image") MultipartFile slider_image)
	{	
		List<String>contentTypes= Arrays.asList("image/PNG","image/png","image/jpg","image/JPG","image/JPEG","image/jpeg");
		String avatarType=avatar.getContentType();
				if(!contentTypes.contains(avatarType)){
					errors.rejectValue("movie_avatar_image","movie","You are not uploading an image");
				}
				
				String sliderType=slider_image.getContentType();
				if(!contentTypes.contains(sliderType)){
					errors.rejectValue("slider_image_1","movie","You are not uploading an image");
				}		
			if(avatar.isEmpty()){
				errors.rejectValue("movie_avatar_image","movie","You haven't select an Avatar for movie yet !");
			}
			if(slider_image.isEmpty()){
				errors.rejectValue("slider_image_1","movie","You haven't select a slider Image_1 for movie yet !");
			}
			if(movie.getTrailer_link().contains("https")==false || movie.getTrailer_link().contains("embed")==false){
				errors.rejectValue("trailer_link","movie","This is not a Youtube link or embed Youtube link");
			}
				
			
										//ADD correct format 
			movie.setIntroduction("<p> "+ movie.getIntroduction()+" </p>");
			movie.setMovie_name(movie.getMovie_name().toUpperCase());
					if(CheckMovieExist(movie)==false){
						errors.rejectValue("movie_name","movie","This movie is already existed in database!");
					}
				if(errors.hasErrors()){
					model.addAttribute("message","Bạn đang mắc các lỗi sau: ");
					return "main/insert_movie";
				}
				Session session=factory.openSession();
				Transaction t= session.beginTransaction();
				
				
		try{
													//Set slider_1
			//String path_slider_1=context.getRealPath("/resources/images/movie_slider_1/" +slider_image.getOriginalFilename());
			String path_slider_1 = "E:\\hoc java\\DoAn\\WebContent\\resources\\images\\movie_slider_1\\" + slider_image.getOriginalFilename();
			slider_image.transferTo(new File(path_slider_1));
			movie.setSlider_image_1("/DoAn/resources/images/movie_slider_1/" +slider_image.getOriginalFilename());
			
													//Set movie_avatar
			//String path_movie_avatar_image=context.getRealPath("/resources/images/movie_avatar_images/" +avatar.getOriginalFilename());
			String path_movie_avatar_image = "E:\\hoc java\\DoAn\\WebContent\\resources\\images\\movie_avatar_images\\" + avatar.getOriginalFilename();
			avatar.transferTo(new File(path_movie_avatar_image));
			movie.setMovie_avatar_image("/DoAn/resources/images/movie_avatar_images/" +avatar.getOriginalFilename());				
			session.save(movie);
			t.commit();
			return "redirect:/main/show_list_movie.htm";
		}catch(Exception e){
			t.rollback();
			model.addAttribute("message","thêm thất bại");
			
		}finally{
			session.close();
		}
		return "main/insert_movie";
	}
	
																//Update Movie
	@RequestMapping(value="update_movie/{movie_id}",method=RequestMethod.GET)
	public String update_movie(ModelMap model,@PathVariable("movie_id") Integer movie_id){
		
		
		model.addAttribute("movie",new Movie());
		return "main/update_movie";
	}
	
	
	@RequestMapping(value="update_movie/{movie_id}",method=RequestMethod.POST)
	public String update_movie(ModelMap model,@Validated @ModelAttribute("movie")Movie movie,BindingResult errors,@PathVariable("movie_id")Integer movie_id,
								@RequestParam("avatar") MultipartFile avatar,@RequestParam("slider_image") MultipartFile slider_image)
	{	
		
		
		
		List<String>contentTypes= Arrays.asList("image/PNG","image/png","image/jpg","image/JPG","image/JPEG","image/jpeg");
		String avatarType=avatar.getContentType();
				if(!contentTypes.contains(avatarType)){
					errors.rejectValue("movie_avatar_image","movie","You are not uploading an image");
				}
				
				String sliderType=slider_image.getContentType();
				if(!contentTypes.contains(sliderType)){
					errors.rejectValue("slider_image_1","movie","You are not uploading an image");
				}		
			if(avatar.isEmpty()){
				errors.rejectValue("movie_avatar_image","movie","You haven't select an Avatar for movie yet !");
			}
			if(slider_image.isEmpty()){
				errors.rejectValue("slider_image_1","movie","You haven't select a slider Image_1 for movie yet !");
			}
			if(movie.getTrailer_link().contains("https")==false || movie.getTrailer_link().contains("embed")==false){
				errors.rejectValue("trailer_link","movie","This is not a Youtube link or embed link type");
			}
			
										//ADD correct format 
			movie.setIntroduction("<p> "+ movie.getIntroduction()+" </p>");
			movie.setMovie_name(movie.getMovie_name().toUpperCase());
			
				if(errors.hasErrors()){
					model.addAttribute("message","Bạn đang mắc các lỗi sau: ");
					return "main/update_movie";
				}
				Session session=factory.openSession();
				Transaction t= session.beginTransaction();
				
				
		try{
													//Set slider_1
			String path_slider_1=context.getRealPath("/resources/images/movie_slider_1/" +slider_image.getOriginalFilename());
			slider_image.transferTo(new File(path_slider_1));
			movie.setSlider_image_1("/DoAn/resources/images/movie_slider_1/" +slider_image.getOriginalFilename());
			
													//Set movie_avatar
			String path_movie_avatar_image=context.getRealPath("/resources/images/movie_avatar_images/" +avatar.getOriginalFilename());
			avatar.transferTo(new File(path_movie_avatar_image));
			movie.setMovie_avatar_image("/DoAn/resources/images/movie_avatar_images/" +avatar.getOriginalFilename());				
			session.update(movie);
			t.commit();
			return "redirect:/main/show_list_movie.htm";
		}catch(Exception e){
			t.rollback();
			model.addAttribute("message","thêm thất bại");
			
		}finally{
			session.close();
		}
		return "main/update_movie";
	}
	@RequestMapping(value="delete_movie/{movie_id}")
	public String delete(ModelMap model, @ModelAttribute("movie")Movie movie,@PathVariable("movie_id")Integer movie_id){
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try{
			session.delete(movie);
			t.commit();
			return "redirect:/main/show_list_movie.htm";
		}catch(Exception e){
			t.rollback();
			model.addAttribute("message","Xóa mới thất bại");
			
		}finally{
			session.close();
		}
		return "main/show_list_movie";
	}
		
	
}
