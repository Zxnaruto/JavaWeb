function add_shoppingcart(btn) {//将btn(dom)转换为jQuery对象 
		//获取input标签的父类td 的所有元素
		var tds = $(btn).parent().siblings();//获取商品的信息，有n列就有n个tds.eq(),里面的参数从零开始，siblings() 获得匹配集合中每个元素的同胞，通过选择器进行筛选是可选的。
		var id=tds.eq(0).text();
		var name = tds.eq(1).text();//商品名称，eq将匹配元素集合缩减为位于指定索引的新元素。
		var price = tds.eq(2).text();//商品价格
		var num=1;
		
		$.ajax({
	        url:contextPath+"/ShopCarServlet",
	        method:"post",
	        data:{id:id,name:name,price:price,num:num,action:"add"},
	        success:function(jsonStr){
	            var result=eval("("+jsonStr+")");
	            
	            if(result.status==1){
	            	alert(result.data);
	            	var new_tr = $('<tr>'
	        				+'<td>'
	        				+id
	        				+'</td>'
	        				+ '<td>'
	        				+ name
	        				+ '</td>'
	        				+ '<td>'
	        				+ price
	        				+ '</td>'
	        				+ '<td align="center">'
	        				+ '<input type="button" value="-" onclick="change(this, -1);"/> '
	        				+ '<input type="text" size="3" readonly value="1"/> '
	        				+ '<input type="button" value="+" onclick="change(this, 1);"/> '
	        				+ '</td>'
	        				+ '<td>'
	        				+ price
	        				+ '</td>'
	        				+ '<td align="center"><input type="button" value="x" onclick="del(this);"/></td>'
	        				+ '</tr>');
	        		$("#goods").append(new_tr);//生成新行放在表的后面
	        		total();//计算总价格
	            	/* request.getRequestDispatcher("shopcar.jsp").forward(request, response);*/
	            }else{
	            	alert(result.message);
	           
	            }
	        }
	    });
		
	
		
	}

	function del(btn) {
		 // 通过点击按钮,获取当前对象的父类的父类,就是<input>标签的父类<td>的父类<tr>,然后移除即可.
	    // <tr>是行 <td>是列
		var tds = $(btn).parent().siblings();//获取商品的信息，有n列就有n个tds.eq(),里面的参数从零开始，siblings() 获得匹配集合中每个元素的同胞，通过选择器进行筛选是可选的。
		var id=tds.eq(0).text();
		$.ajax({
	        url:contextPath+"/ShopCarServlet",
	        method:"post",
	        data:{id:id,action:"del"},
	        success:function(jsonStr){
	            var result=eval("("+jsonStr+")");
	            if(result.status==1){
	            	alert(result.data);
	            	$(btn).parent().parent().remove();//parent 获得当前匹配元素集合中每个元素的父元素，由选择器筛选（可选）
	            /*	request.getRequestDispatcher("shopcar.jsp").forward(request, response);*/
	            	window.location.reload(true);//刷新一下页面
	            }else{
	            	
	            	alert(result.message);
	            	
	            }
	        }
	    });
		
		total();
		
	
	}

	function total() {
		var trs = $("#goods tr"); // 获取tbody下的所有行，id选择器
		var sum = 0;
		for (var i = 0; i < trs.length; i++) {
			var td = trs.eq(i).children().eq(4);// 获取每一行第5列的值
			var m = td.text();
			sum += parseFloat(m);
		}
		$("#total").text(sum);//得到计算结果，并显示在td中
	}

	function change(btn, n) {
		//获取按钮的弟弟，看是否有弟弟，在点击+时input下面没有紧邻的同辈元素<input>，所以$(btn).prev()，而-时下面有紧邻的元素
		//之后选择prev时就看+号的前面的input里面的值，就是+-中间的，next也是一样的
		var tds = $(btn).parent().siblings();//获取商品的信息，有n列就有n个tds.eq(),里面的参数从零开始，siblings() 获得匹配集合中每个元素的同胞，通过选择器进行筛选是可选的。
		var id=tds.eq(0).text();
		var t = $(btn).next().length == 0 ? $(btn).prev() : $(btn).next();//next 获得匹配元素集合中每个元素紧邻的同辈元素。
		var amount = parseInt(t.val());
		if (amount <= 1 && n < 0) {
			return;
		}
		t.val(amount + n);
		amount = t.val();
		$.ajax({
	        url:contextPath+"/ShopCarServlet",
	        method:"post",
	        data:{id:id,amount:amount,action:"change"}
		
	    });
		/*var tds = $(btn).parent().siblings();//input的父类td的所有元素
*/		var price = tds.eq(2).text();//单价
		var m = price * amount;//算出单个物品的总价
		tds.eq(3).text(m);//显示出来，单价求和    3是应为siblings获得的是相似的td

		total();
	
	}