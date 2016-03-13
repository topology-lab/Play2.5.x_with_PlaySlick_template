package controllers

import javax.inject.Inject
import play.Logger
import play.api.mvc.Action
import play.api.mvc.Controller
import slick.codegen.SourceCodeGenerator

/**
 * @author topology
 * val slickDriver = "slick.driver.PostgresDriver"
 * <br>
 * この参照がmainとして実行するとClassNotFoundが出た。
 * playのリクエストから実行することで解決する。
 */
class Generator @Inject() extends Controller {

	def main = Action {

		Logger.info("start")

		val slickDriver = "slick.driver.PostgresDriver"
		val jdbcDriver = "org.postgresql.Driver"
		val url = "jdbc:postgresql://localhost/playdb"
		val outputFolder = "app/"
		val pkg = "models"
		val user = "playuser"
		val password = "playuser"

		SourceCodeGenerator.main(
			Array(
				slickDriver,
				jdbcDriver,
				url,
				outputFolder,
				pkg,
				user,
				password))

		Logger.info("end")
		
		Ok(views.html.index("Your new application is ready."))
	}
}
