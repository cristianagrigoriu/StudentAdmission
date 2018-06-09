<html>
<head>
	<title>Student Admission Grid</title>
	<script src="jquery-3.3.1.slim.js"></script>
</head>
<body>
	
	<!--<input type="button" value="Add Student Manually" id="addStudentManually">
		
	  <div>
		<textarea id="firstName" style="display: none" placeholder="First Name"></textarea>
	  	<textarea id="lastName" style="display: none" placeholder="Last Name"></textarea>
	  	<textarea id="gradeHighschool" style="display: none" placeholder="Grade Highschool"></textarea>
	  	<textarea id="gradeExam" style="display: none" placeholder="Grade Exam"></textarea>
  	</div>
  	-->
  	
  	<form id="addStudentManuallyForm" action="StudentAdmissionServlet" method="post">
	    <input type="text" name="firstName" style="display: none" placeholder="First Name" id="firstName"/>
	    <input type="text" name="lastName" style="display: none" placeholder="Last Name" id="lastName"/>
	    <input type="text" name="gradeHighschool" style="display: none" placeholder="Grade Highschool" id="gradeHighschool"/>
	    <input type="text" name="gradeExam" style="display: none" placeholder="Grade Exam" id="gradeExam"/>
	    <input type="submit" name="addStudentManually" value="Add Student Manually" id="addStudentManually"/>
	</form>
  
  <form action="http://google.com">
    <input type="submit" value="Add Student From File" id="addStudentFromFile"/>
  </form>
  
  <form action="http://google.com">
    <input type="submit" value="Delete Student" id="deleteStudent"/>
  </form>
  
  <form action="http://google.com">
    <input type="submit" value="Update Student" id="updateStudent"/>
  </form>
  
  <!--<form action="http://google.com">
    <input type="submit" value="Filter Students" id="FilterStudents"/>
  </form>-->
  
  <table style="width:100%">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th> 
    <th>Grade 1</th>
    <th>Grade 2</th>
    <th>Average</th>
  </tr>
  <tr>
    <td>Cris</td>
    <td>Smith</td> 
    <td>50</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>Jackson</td> 
    <td>94</td>
  </tr>
</table>
  
  <style>
	  
	  textarea {
	    display: inline-block; //Or display: inline; 
	  }
	  
	  table, th, td {
    	border: 1px solid black;
	  }
  </style>
  
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>

	<script type="text/javascript">
		     
	     $(document).ready(function(){
	    	 
	    		$( "#addStudentManually" ).click(function( event ) {
					if ($("#firstName").is(":visible")) {
	    	    		var firstName = $("#firstName").val();
	    	    		var lastName = $("#lastName").val();
	    	    		var gradeHighschool = $("#gradeHighschool").val();
	    	    		var gradeExam = $("#gradeExam").val();
		    	    	alert(firstName + " " + gradeExam);
		    	    	$.post($form.attr("action"), $form.serialize(), function(response) {
		    		        // ...
		    		    });
	    	    	}
	    	    	else {
	    	    		showStudentAttributes();
		    	        hideOtherButtons();
	    	    	}
	    		    event.preventDefault(); // Important! Prevents submitting the form.
	    		});
	    	 
	   	    function showStudentAttributes () {
	   	    	$("#firstName").show();
	   	    	$("#lastName").show();
	   	    	$("#gradeHighschool").show();
	   	    	$("#gradeExam").show();
	   	    };
	   	    
		   	 function hideOtherButtons () {
		   		$("#addStudentFromFile").hide();
	   	    	$("#deleteStudent").hide();
	   	    	$("#updateStudent").hide();
		   	    };
	   		 });
	</script>

</body>



</html>