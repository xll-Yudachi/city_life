$(function () {
  $('.purpose-row > span').click(function () {
     $(this).addClass("cur")
     $(this).siblings().removeClass("cur")
  })

  $('.agree-policy').click(function () {

    if (!$(this)[0].checked){
      $('#submitBtn').attr('disabled', 'true')
      $('#submitBtn').addClass('btn-disabled').addClass('el-button').addClass('btn-disabled').addClass('el-button--default').addClass('is-disabled')
    }else{
      $('#submitBtn').removeAttr('disabled')
      $('#submitBtn').removeClass().addClass('btn')
    }
  })

  // 点击事件
  $('#smsBtn').click(function () {
    //点击按钮时，按钮禁用
    $(this).disabled = true;
    // 倒计时5秒
    let index = 5;
    // 按钮文字为获取验证码(5)
    $(this).value = `发送验证码 (${index}) `;
    // 定时器，延迟 1s
    let timer = setInterval(function () {
      index--;
      $(this).value = `发送验证码 (${index}) `;
      // 当倒计时等等为0时
      if (index == 0) {
        // 停止计时
        clearInterval(timer);
        // 按钮禁用取消
        $(this).disabled = false;
        // 将文字值重置为获取验证码
        $(this).value = '发送验证码';
      }
    }, 1000)
  })

})
