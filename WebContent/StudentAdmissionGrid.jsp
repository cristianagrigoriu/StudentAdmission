<html>
<head><title>Student Admission Grid</title></head>
<body>

  <form action="http://google.com">
    <input type="submit" value="Add Student Manually" />
  </form>
  
  <form action="http://google.com">
    <input type="submit" value="Add Student From File" />
  </form>
  
  <form action="http://google.com">
    <input type="submit" value="Delete Student" />
  </form>
  
  <form action="http://google.com">
    <input type="submit" value="Update Student" />
  </form>
  
  <form action="http://google.com">
    <input type="submit" value="Filter Students" />
  </form>
  
  <table style="width:100%">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th> 
    <th>Grade 1</th>
    <th>Grade 2</th>
    <th>Average</th>
  </tr>
  <tr>
    <td><div contenteditable>Jill</td>
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
	  form {
	    display: inline-block; //Or display: inline; 
	  }
	  
	  table, th, td {
    	border: 1px solid black;
	  }
  </style>
  
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>