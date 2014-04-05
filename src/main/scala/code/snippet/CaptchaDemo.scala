package code.snippet

import code.lib.ReCaptcha
import net.liftweb.util.Helpers.strToCssBindPromoter
import net.liftweb.http.{ S, SHtml }
import net.liftweb.http.js.JsCmds.Run

object CaptchaDemo extends ReCaptcha {

  def render = {
    "#captcha" #> captchaXhtml &
      "#validateCaptcha" #> SHtml.ajaxSubmit("Done", () => {
        if (validateCaptcha.isDefined) {
          // invalid captcha error message
          S.error("captchaError", "Invalid captcha")
          reloadCaptcha
        } else
          // code 
          Run("$('#captchaDemoModal').modal('hide');$('.error').remove()") & reloadCaptcha
      })
  }

}