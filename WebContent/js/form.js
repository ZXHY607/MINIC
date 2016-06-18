$(function(){
	$(".select").each(function(){
		var value = $(this).attr("value");
		if(value!=null&&value!='')
		$(this).val(value);
	});
	$(".ajax-form").submit(function(){
		ajax(this);
		return false;
	});
});

function ajax(fm)
{
		$.ajax(
		{
			type:"post",
			url:$(fm).attr("action"),
			data:$(fm).serialize(),
			async:true,
			success:function(msg){
				alert(msg);
			}
		});
}