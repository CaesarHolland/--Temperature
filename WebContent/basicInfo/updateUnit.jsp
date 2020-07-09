<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="updateUnitServlet" method="post" onsubmit="check(this)"> 
	  <table align="center" width="450"> 
	    <tr> 
	      <td align="center" colspan="2"> 
	        <h2>修改往来单位信息</h2> 
	        <hr> 
	      </td> 
	    </tr> 
	  
	    <tr> 
	      <td align="right">单位代码：</td> 
	      <td><input type="text" name="unitCode" value=${unitCode } ></td> 
	    </tr> 
	  
	    <tr> 
	      <td align="right">单位性质：</td> 
	      <td><input type="text" name="unitNature"></td> 
	    </tr> 
	  
	    <tr> 
	      <td align="right">助记码：</td> 
	      <td><input type="text" name="helpCode" /></td> 
	    </tr> 
	  
	    <tr> 
	      <td align="right">所属地区：</td> 
	      <td><input type="text" name="region" /></td> 
	    </tr> 
	    
	     <tr> 
	      <td align="right">所属行业：</td> 
	      <td><input type="text" name="industry" /></td> 
	     </tr> 
	    
	     <tr> 
	      <td align="right">单位类别：</td> 
	      <td><input type="text" name="unitClass" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">单位名称：</td> 
	      <td><input type="text" name="unitName" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">联系人：</td> 
	      <td><input type="text" name="contacts" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">地址：</td> 
	      <td><input type="text" name="address" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">开户银行：</td> 
	      <td><input type="text" name="bank" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">银行账号：</td> 
	      <td><input type="text" name="account" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">业务电话：</td> 
	      <td><input type="text" name="phone" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">Email：</td> 
	      <td><input type="text" name="email" /></td> 
	     </tr> 
	     
	     <tr> 
	      <td align="right">备注：</td> 
	      <td><input type="text" name="info" /></td> 
	     </tr> 
	     
	    <tr> 
	      <td align="center" colspan="2">
	      <input type="submit" value="修    改"> 
	      </td> 
	    </tr> 
	  </table> 
	</form>
	<h2 align="center"> 
	  <a href="ChangeServlet">返回</a> 
	</h2> 
</body>
</html>