package tools

import javax.inject.Inject
import models.Tables
import play.api.mvc.Action
import play.api.mvc.Controller

class DDL @Inject() extends Controller {

	def gen = Action {
		Tables.ddl.createStatements.foreach(println)
		Ok(views.html.index("Your new application is ready."))
	}
}