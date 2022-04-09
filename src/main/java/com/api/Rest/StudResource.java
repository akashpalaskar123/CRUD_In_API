package com.api.Rest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class StudResource
{
	StudentDao dao =new StudentDao();
	@GET 
	@Path("getStudents")
	 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Students> getstuds()
	{
		System.out.println("....1");		
		return dao.getstud();
		
	}
	
	
	@GET
	@Path("getStudentById/{id}")
	 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Students getstud(@PathParam("id")int id)
		{
		return dao.getstuds(id); 
		}
	

	@POST
	@Path("addStudent")
	public Students createStud(Students s1)
	{
		dao.create(s1);
		return s1;
			
	}
	
	@PUT
	@Path("updateStudentById/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public String updateStudentBYId(@PathParam("id")int id,Students s1)
	{
		System.out.println("updated successfully"+s1+" "+id);
		 dao.updatestudent(id,s1); 
//		 return "update success";
		 return "updated successfully";
	}
	
	@DELETE
	@Path("deleteStudentById/{id}")
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public String deleteStudentBYId(@PathParam("id")int id)
	{
		 dao.deleteStudent(id); 
		return "delete successfully";	
	}

	
}
