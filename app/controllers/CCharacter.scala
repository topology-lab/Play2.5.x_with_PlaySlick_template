package controllers

import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.i18n.I18nSupport
import play.api.i18n.MessagesApi
import play.api.mvc.Controller
import slick.driver.JdbcProfile
import models.Tables.Characters
import play.api.mvc.Action
import scala.concurrent.Future
import play.api.Play
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import models.Tables
import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.MySQLDriver.api._

class CCharacter @Inject() (
	val dbConfigProvider: DatabaseConfigProvider,
	val messagesApi: MessagesApi) extends Controller
		with HasDatabaseConfigProvider[JdbcProfile] with I18nSupport {

	import driver.api._

	val conn = dbConfigProvider.get[JdbcProfile]

	/**
	 * 一覧表示
	 */
	def list = //TODO
		Action.async { implicit request =>
			val query = Tables.Users.map(_.userId)
			val resultingUsers = dbConfig.db.run(query.result)
			resultingUsers.map(user => Ok(views.html.index(user.toString)))
		}
	/**
	 * 編集画面表示
	 */
	def edit(character_id: Option[Int]) = TODO

	/**
	 * 登録実行
	 */
	def create = TODO

	/**
	 * 更新実行
	 */
	def update = TODO

	/**
	 * 削除実行
	 */
	def remove(character_id: Int) = TODO
}