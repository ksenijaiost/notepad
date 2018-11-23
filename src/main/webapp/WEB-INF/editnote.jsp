<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>Edition</h1><hr>
Today is: <%= new java.util.Date()%>
<hr align="left" width="325" size=5>

<script type="text/javascript">
    function validate_texts() {
	    valid = true;
        if ( document.editing.title.value == "" ) {
            alert ( "Please, write title." );
            valid = false;
        }
        if ( document.editing.noteBody.value == "" ) {
            alert ( "Please, write your text." );
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

<form action="ActionEdit" method="post" name="editing">
<var="note" items="${note}">
<input name="noteId" type="hidden" value="${note.id}">
Title:
<input name="title" type="text" size="45" value="${note.name}">
<br>
Your text: <br>
<textarea name="noteBody" rows="10" cols="52"><c:out value="${note.body}"/></textarea>
<br> <br>
<button name="action" type="submit" value="save" onclick="return validate_texts();" class="new">save</button>
<button type="reset" value="reset" class="new">reset</button>
<button name="action" type="submit" value="delete" class="new">delete</button>
<button name="action" type="submit" value="cancel" class="new">cancel</button>
</form>
</body>
</html>