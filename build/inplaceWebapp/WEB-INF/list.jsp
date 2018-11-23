<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h1>Notebook!</h1><hr>
Today is: <%= new java.util.Date()%>
<hr align="left" width="325" size=5>

<script type="text/javascript">
    checkobj=0;
    function checkAvail(obj) {
        if (obj.checked) checkobj++;
            else checkobj--;
    }
    function delete_notes() {
    	valid = true;
        if (checkobj<=0) {
            alert ("Please, select one or more notes to delete.");
            valid = false;
        }
        return valid;
    }
    function edit_notes() {
    	valid = true;
        if (checkobj<=0 || checkobj>=2) {
            alert ("Please, select one note to editing.");
            valid = false;
        }
        return valid;
    }
</script>

<style type="text/css">
   TABLE { width: 400px; border: 1px solid black;  border-bottom: none; }
   TD, TH { padding: 3px; }
   TH { text-align: left; background: black; color: white; border: 1px solid white; }
   TD { border-bottom: 1px solid black; }
  </style>

<style type="text/css">
    button.new {
       padding: 3px 7px;
       color: #fff;
        -moz-border-radius: 5px;
        -webkit-border-radius: 5px;
       border-radius:  5px;
       border: 2px solid #666;
       background: -moz-linear-gradient(#f2f2f2, #777, #404040, #252525);
       background: -webkit-gradient(linear, 0 0, 0  100%, from(#f2f2f2), to(#252525), color-stop(0.6, #777), color-stop(0.6,  #404040));
      }
  </style>

<form action="ActionDo" name="submits">
<button name="action" type="submit" value="create" class="new">create</button>
<button name="action" type="submit" value="edit" onclick="return edit_notes();" class="new">edit</button>
<button name="action" type="submit" value="delete" onclick="return delete_notes();" class="new">delete</button>
<br><br>

<table cellspacing="0">
<tr>
    <th>&nbsp;</th><th>Title</th><th>Body</th>
   </tr>

<c:forEach var="note" items="${notes}">
    <tr>
<td width="20"><input type="checkbox" name="noteId" id="ch" value="${note.id}" onclick="checkAvail(this)">
</td>
<td width="180"><label for="ch">${note.name}</label></td>
<td width="200"><label for="ch">${note.body}</label></td>
    </tr>
</c:forEach>

</table>
</form>
</body>
</html>

