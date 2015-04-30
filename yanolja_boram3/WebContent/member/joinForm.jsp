<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>회원가입 페이지</title>
    <link rel="stylesheet" href="style/theme/bootstrap.css" media="screen">
    <link rel="stylesheet" href="style/theme/usebootstrap.css">
<script>
function idcheck(){
	
	
	var id=document.joinform.userid.value;
	window.open('./member/idcheck.jsp?userid='+id,'win',width="300", heigth="200");
}
function CheckData(){
	/* var title= document.myform.title;
	var content = document.myform.content; */
	
	var id= document.joinform.userid.value;
	if(id.length<4){
		alert("아이디가 너무 짧습니다.");
		document.joinform.userid.focus();
		return;
	}
	
	
	var pic= document.joinform.profile_pic.value;
	if(pic==""){
		alert("사진을 첨부하여 주십시오.");
		document.joinform.profile_pic.focus();
		return;
	}
	
	var nam= document.joinform.name.value;
	if(nam==""){
		alert("이름을 입력해주십시오.");
		document.joinform.name.focus();
		return;
	}
	
	var pwd= document.joinform.pwd.value;
	if(pwd==""){
		alert("비밀번호를 입력해주십시오.");
		document.joinform.pwd.focus();
		return;
	}else if(pwd.length<5){
		alert("비밀번호를 4자리 이상 입력해주십시오.");
		document.joinform.pwd.focus();
		return;
	}

	var chpwd= document.joinform.pwd1.value;
	if(chpwd==""){
		alert("비밀번호확인을 입력해주십시오.");
		document.joinform.pwd1.focus();
		return;
	}if(pwd!=chpwd){
		alert("비밀번호를 동일하게 입력해주십시오.");
		document.joinform.pwd1.focus();
		return;
	}
	
	var ph= document.joinform.phone.value;
	if(ph==""){
		alert("전화번호를 입력해주십시오.");
		document.joinform.phone.focus();
		return;
	}

	var mail= document.joinform.email.value;
	if(mail==""){
		alert("이메일을 입력해주십시오.");
		document.joinform.email.focus();
		return;
	}

	document.joinform.submit();
}
</script>

</head>
<body>
<form name="joinform" action="./MemberJoinAction.me" method="post" enctype="multipart/form-data">


<div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header">
              <h1 id="forms">JOIN</h1>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-6">
            <div class="well bs-component">
              <form class="form-horizontal">
                <fieldset>
                  <legend>회원가입</legend>
                  <div class="form-group">
                    <label for="inputId" class="col-lg-2 control-label">ID</label>
                    <div class="col-lg-10">
                      <input type="text" class="form-control" id="userid" name="userid" placeholder="userid">
                    </div>
                     <label for="inputProfile" class="col-lg-2 control-label">프로필사진</label>
                    <div class="col-lg-10">
                      <input type="file" class="form-control" id="profile_pic" name="profile_pic" placeholder="profile_pic">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                      <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox"> Checkbox
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="textArea" class="col-lg-2 control-label">Textarea</label>
                    <div class="col-lg-10">
                      <textarea class="form-control" rows="3" id="textArea"></textarea>
                      <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-lg-2 control-label">Radios</label>
                    <div class="col-lg-10">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                          Option one is this
                        </label>
                      </div>
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                          Option two can be something else
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="select" class="col-lg-2 control-label">Selects</label>
                    <div class="col-lg-10">
                      <select class="form-control" id="select">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </select>
                      <br>
                      <select multiple="" class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button class="btn btn-default">Cancel</button>
                      <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>
          </div>
          <div class="col-lg-4 col-lg-offset-1">

              <form class="bs-component">
                <div class="form-group">
                  <label class="control-label" for="focusedInput">아이디 : </label>
                  <input class="form-control" id="focusedInput" type="text" value="This is focused...">
                	
                </div>

                <div class="form-group">
                  <label class="control-label" for="disabledInput">Disabled input</label>
                  <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here..." disabled="">
                </div>

                <div class="form-group has-warning">
                  <label class="control-label" for="inputWarning">Input warning</label>
                  <input type="text" class="form-control" id="inputWarning">
                </div>

                <div class="form-group has-error">
                  <label class="control-label" for="inputError">Input error</label>
                  <input type="text" class="form-control" id="inputError">
                </div>

                <div class="form-group has-success">
                  <label class="control-label" for="inputSuccess">Input success</label>
                  <input type="text" class="form-control" id="inputSuccess">
                </div>

                <div class="form-group">
                  <label class="control-label" for="inputLarge">Large input</label>
                  <input class="form-control input-lg" type="text" id="inputLarge">
                </div>

                <div class="form-group">
                  <label class="control-label" for="inputDefault">Default input</label>
                  <input type="text" class="form-control" id="inputDefault">
                </div>

                <div class="form-group">
                  <label class="control-label" for="inputSmall">Small input</label>
                  <input class="form-control input-sm" type="text" id="inputSmall">
                </div>

                <div class="form-group">
                  <label class="control-label">Input addons</label>
                  <div class="input-group">
                    <span class="input-group-addon">$</span>
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Button</button>
                    </span>
                  </div>
                </div>
              </form>

          </div>
        </div>
      </div>


<!-- 
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>회원가입 페이지</font></b>
		</td>
	</tr>
	<tr>
		<td>아이디 : </td>
		<td><input type="text" name="userid"/></td>
		<td><input type="button" name="useridcheck" onclick="idcheck()"/></td>
	</tr>
	<tr>
		<td>프로필사진 : </td>
		<td><input type="file" name="profile_pic"/></td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td><input type="password" name="pwd"/></td>
	</tr>
	<tr>
		<td>비밀번호 확인 : </td>
		<td><input type="password" name="pwd1"/></td>
	</tr>
	<tr>
		<td>전화번호(숫자만) : </td>
		<td><input type="text" name="phone" /></td>
	</tr>
	<tr>
		<td>이메일 주소 : </td>
		<td><input type="text" name="email" size=30/></td>
	</tr>
	<tr>
		<td>응원하는 팀 : </td>
		<td>
			<input type="radio" name="team_no_fk" value="0" checked/>무소속
			<input type="radio" name="team_no_fk" value="1"/>삼성
			<input type="radio" name="team_no_fk" value="2"/>넥센
			<input type="radio" name="team_no_fk" value="3"/>NC
			<input type="radio" name="team_no_fk" value="4"/>LG
			<input type="radio" name="team_no_fk" value="5"/>SK
			<input type="radio" name="team_no_fk" value="6"/>두산
			<input type="radio" name="team_no_fk" value="7"/>롯데
			<input type="radio" name="team_no_fk" value="8"/>KIA
			<input type="radio" name="team_no_fk" value="9"/>한화
			<input type="radio" name="team_no_fk" value="10"/>KT
		</td>
	</tr>
	<tr>
		<td colspan="2" align=center>
			<input type="button" value="회원가입" onclick="CheckData()">
			<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</center>
 -->
 </form>
 
  <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
	<script src="bootstrap/usebootstrap.js"></script>
 
</body>
</html>