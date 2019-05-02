<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/include/header.jsp"%>

	<!-- 본문 컨텐츠 시작 -->
	<div class="cont sub_inner mem_cont join">
		<div class="login_wrap">
			<div class="mem_title">
				회원가입
				<span>굿파이에 회원가입하세요.</span>
			</div>

			<div class="join_form form_write">
				<form action="<c:url value="/users" />" method="post" onsubmit="return checkForm(this)">
					<table>
						<caption></caption>
						<colgroup>
							<col style="width: 25%;" />
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>이메일</th>
								<td>
									<div>
										<input type="text" name="email" class="type1" placeholder="사용할 이메일을 입력해 주세요." />
										<input type="button" class="btn btn_lightgray" value="인증번호 발송" onclick="sendAuthKey()" />
									</div>
									<div class="mb00">
										<input type="text" name="key" class="type1" placeholder="인증번호 6자리를 입력해 주세요." />
										<input type="button" class="btn btn_lightgray" value="인증번호 확인" />
									</div>
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<input type="text" name="password" placeholder="비밀번호를 입력해 주세요." />
								</td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td>
									<input type="text" name="password_check" placeholder="비밀번호를 다시 한 번 입력해 주세요." />
								</td>
							</tr>
							<tr>
								<th>이름</th>
								<td>
									<input type="text" name="name" placeholder="이름을 입력해 주세요." />
								</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>
									<input type="text" name="phone" placeholder="연락처를 입력해 주세요." />
								</td>
							</tr>
							<tr>
								<th>성별</th>
								<td>
									<label class="radio_style">
										<input type="radio" name="gender" value="M" />
										<span>남</span>
									</label>
									<label class="radio_style">
										<input type="radio" name="gender" value="F" />
										<span>여</span>
									</label>
								</td>
							</tr>
						</tbody>
					</table>

					<div class="btn_wrap text_center">
						<input type="submit" value="회원가입" class="btn btn_black">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- //. 본문 컨텐츠 시작 -->

	<script>
		function checkForm(obj) {
			var isSuccessed = isValid(obj.email, "이메일", obj.email, "email")
							&& isValid(obj.password, "비밀번호", obj.password, "password")
							&& isEqual(obj.password, obj.password_check, "비밀번호와 비밀번호 확인에 입력된 값")
							&& isValid(obj.name, "이름", obj.name, null)
							&& isValid(obj.phone, "연락처", obj.phone, "phone")
							&& isValid(obj.gender, "성별", obj.gender, null);

			console.log( isSuccessed );
			return false;

			var formData = $(obj).serializeArray();
			var params = new Object();

			$(formData).each(function(idx, obj) {
				if ( isEmpty(obj) == false ) {
					params[obj.name] = obj.value;
				}
			});

			var uri = '<c:url value="/users" />';

// 			$.ajax({
// 				url : uri,
// 				type : "post",
// 				dataType : "json",
// 				data : 
// 			});
		}
	</script>

<%@include file="/WEB-INF/include/footer.jsp"%>
