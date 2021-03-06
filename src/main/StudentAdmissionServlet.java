package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

/**
 * Servlet implementation class StudentAdmissionServlet
 */
@WebServlet("/StudentAdmissionServlet")
public class StudentAdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAdmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FileReader in = new FileReader("/Users/crist/eclipse-workspace/StudentAdmission/students.txt");
	    BufferedReader br = new BufferedReader(in);
		JSONArray students = new JSONArray();
	    
		String line;
		while ((line = br.readLine()) != null) {
		    System.out.println(line);
		    JSONObject obj;
			try {
				obj = new JSONObject(line);
				//String firstName = obj.getString("firstName");
				//String firstName = obj.getJSONObject("firstName").getString(key);
				String lastName = obj.getString("lastName");
				Float average = BigDecimal.valueOf(obj.getDouble("average")).floatValue();
				AdmissionStatus status = AdmissionStatus.valueOf(obj.getString("status"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		br.close();
		
		//request.setAttribute("products", products); // Will be available as ${products} in JSP
        //request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out = response.getWriter();
		//Date date = new Date();
		//out.println("<h2>Hi There!</h2><br/><h3>Date="+date +"</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		assert request.getParameterMap().containsKey("firstName");
		assert request.getParameterMap().containsKey("lastName");
		assert request.getParameterMap().containsKey("gradeHighschool");
		assert request.getParameterMap().containsKey("gradeExam");
		
		String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    Float gradeHighschool = Float.valueOf(request.getParameter("gradeHighschool"));
	    Float gradeExam = Float.valueOf(request.getParameter("gradeExam"));
	    Student newStudent = new Student(firstName, lastName, gradeHighschool, gradeExam);
	    writeStudentToFile(newStudent);
	    PrintWriter out = response.getWriter();
	    out.println("<p>" + firstName + " " + lastName + " " + gradeHighschool + " " + gradeExam + "</p>");	    
	}

	private void writeStudentToFile(Student s) {
		JSONObject student = new JSONObject();
 
		assert s.getFirstName() != null;
		assert String.class.isInstance(s.getFirstName());
		assert s.getLastName() != null;
		assert String.class.isInstance(s.getLastName());
		assert s.getAverage() != 0;
		assert Float.class.isInstance(s.getFirstName());
		
		try {
			student.put("firstName: ", s.getFirstName());
			student.put("lastName: ", s.getLastName());
			student.put("gradeHighschool: ", s.getGradeHighschool());
			student.put("gradeExam: ", s.getGradeHighschool());
			student.put("average: ", s.getAverage());
			student.put("status: ", s.getStatus());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(FileWriter fw = new FileWriter("/Users/crist/eclipse-workspace/StudentAdmission/students.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
			
		//assert fw != null;
				
		PrintWriter out = new PrintWriter(bw))
		{
	    	out.println(student.toString());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
