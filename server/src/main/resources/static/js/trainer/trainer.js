/**
 * 
 */

/**
 * 
 */
var main = {
    init : function (){
		
		var _this = this;
      
      $("#trainerSaveBtn").click(function(){
		 _this.trainerSave();
	  });
	  
      $("#updateMoveBtn").click(function(){
            window.location.href='/trainer/update/' + $(this).parent().siblings().eq(0).text();
	  });
	  
	 $("#trainerUpdateBtn").click(function(){
             _this.trainerUpdate();
	  });
	  
	 $("#trainerRemoveBtn").click(function(){
             _this.trainerRemoveBtn();
	  });
	  
	 $("#trainerSelectBtn").click(function(){
		 	$("#previewTrainerDetail").removeClass( 'd-none' );
		 	var id = $(this).parent().siblings().eq(0).text();
             _this.trainerSelectBtn(id);
	  });
	  
	  $('input[name=updateTrainerSex][value=' + $("#prev_sex").val()+']').prop("checked","checked");
	  $('select#roleCd option[value=' + $("input#roleCd").val()+ ']').prop("selected","selected");
	  $('select#stateCd option[value=' + $("input#stateCd").val()+ ']').prop("selected","selected");
	 
    },
    trainerSave : function(){
		var data = {
            name : $('.trainer-save-form#name').val(),
            dept : $('.trainer-save-form#dept').val(),
        };
        
        $.ajax({
           type :'POST',
           url : '/api/trainer',
           dataType : 'json',
           contentType : 'application/json; charset=utf-8',
           data : JSON.stringify(data)
        }).done(function(){
            alert('신규 트레이너 정보가 등록되었습니다.');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
	},
	trainerUpdate : function(){
		var id = $('#selectTrainerId').val();
		
		var data = {
            name : $('.trainer-update-form#name').val(),
            dept : $('.trainer-update-form#dept').val(),
        };
                
        $.ajax({
           type :'POST',
           url : '/api/trainer/' + id,
           dataType : 'json',
           contentType : 'application/json; charset=utf-8',
           data : JSON.stringify(data)
        }).done(function(){
            alert('신규 트레이너 정보가 수정되었습니다.');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
	},
	trainerRemoveBtn : function(){
		var id = $('#selectTrainerId').val();
		
        $.ajax({
           type :'DELETE',
           url : '/api/trainer/' + id,
           dataType : 'json',
           contentType : 'application/json; charset=utf-8'
        }).done(function(){
            alert('신규 트레이너 정보가 삭제되었습니다.');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
	},
	trainerSelectBtn : function(id){
		        
        $.ajax({
           type :'GET',
           url : '/api/trainer/' + id,
           dataType : 'json',
           contentType : 'application/json; charset=utf-8'
        }).done(function(data){
			$('.trainer-update-form#name').val(data.name);
			$('#selectTrainerId').val(data.id);
            $('.trainer-update-form#dept').val(data.dept);
            $('.trainer-update-form#createDate').text(data.createDate);
            $('.trainer-update-form#updateDate').text(data.updateDate);
            
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
	},
}

main.init();