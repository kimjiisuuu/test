
/* 등록 유효성 검사 */

function func_reg()
{
	const frm = document.forms[0]
	const schoolname = frm.schoolname
	const schoolemail = frm.schoolemail
	const schoolnumber = frm.schoolnumber
	const licensename = frm.licensename
	const startdate = frm.startdate
	const enddate = frm.enddate
	let isValid = true
	
	
/*	let schoolnumber = /^010-[0-9]{4}-[0-9]{4}$/*/
	
	if(schoolname.value=='')
	{
		alert('학교명은 필수 입력입니다.')
		schoolname.focus()
		isValid = false
	} else
	
	if(schoolemail.value=='')
	{
		alert('학교 이메일은 필수 입력입니다.')
		schoolemail.focus()
		isValid = false
	} else
	
	if(schoolnumber.value=='')
	{
		alert('학교 행정실 전화번호는 필수 입력입니다.')
		schoolnumber.focus()
		isValid = false
	} else
	
	if(licensename.value=='')
	{
		alert('라이센스명은 필수 입력입니다.')
		licensename.focus()
		isValid = false
	} else
	
	if(startdate.value=='')
	{
		alert('구독 시작날짜를 선택해주세요.')
		startdate.focus()
		isValid = false
	} else
	
	if(enddate.value=='')
	{
		alert('구독 종료날짜를 선택해주세요.')
		enddate.focus()
		isValid = false
	} else
	
	if(isValid) 
	{
        frm.submit()
    }


}