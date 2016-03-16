package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.PostgresDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Characters.schema ++ Companies.schema ++ PlayEvolutions.schema ++ Users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Characters
   *  @param characterId Database column character_id SqlType(int4), PrimaryKey
   *  @param name Database column name SqlType(bpchar), Length(32,false)
   *  @param feature Database column feature SqlType(varchar) */
  case class CharactersRow(characterId: Int, name: String, feature: String)
  /** GetResult implicit for fetching CharactersRow objects using plain SQL queries */
  implicit def GetResultCharactersRow(implicit e0: GR[Int], e1: GR[String]): GR[CharactersRow] = GR{
    prs => import prs._
    CharactersRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table characters. Objects of this class serve as prototypes for rows in queries. */
  class Characters(_tableTag: Tag) extends Table[CharactersRow](_tableTag, "characters") {
    def * = (characterId, name, feature) <> (CharactersRow.tupled, CharactersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(name), Rep.Some(feature)).shaped.<>({r=>import r._; _1.map(_=> CharactersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column character_id SqlType(int4), PrimaryKey */
    val characterId: Rep[Int] = column[Int]("character_id", O.PrimaryKey)
    /** Database column name SqlType(bpchar), Length(32,false) */
    val name: Rep[String] = column[String]("name", O.Length(32,varying=false))
    /** Database column feature SqlType(varchar) */
    val feature: Rep[String] = column[String]("feature")
  }
  /** Collection-like TableQuery object for table Characters */
  lazy val Characters = new TableQuery(tag => new Characters(tag))

  /** Entity class storing rows of table Companies
   *  @param companyId Database column company_id SqlType(int4)
   *  @param name Database column name SqlType(varchar) */
  case class CompaniesRow(companyId: Int, name: String)
  /** GetResult implicit for fetching CompaniesRow objects using plain SQL queries */
  implicit def GetResultCompaniesRow(implicit e0: GR[Int], e1: GR[String]): GR[CompaniesRow] = GR{
    prs => import prs._
    CompaniesRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table companies. Objects of this class serve as prototypes for rows in queries. */
  class Companies(_tableTag: Tag) extends Table[CompaniesRow](_tableTag, "companies") {
    def * = (companyId, name) <> (CompaniesRow.tupled, CompaniesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(companyId), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> CompaniesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column company_id SqlType(int4) */
    val companyId: Rep[Int] = column[Int]("company_id")
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
  }
  /** Collection-like TableQuery object for table Companies */
  lazy val Companies = new TableQuery(tag => new Companies(tag))

  /** Entity class storing rows of table PlayEvolutions
   *  @param id Database column id SqlType(int4), PrimaryKey
   *  @param hash Database column hash SqlType(varchar), Length(255,true)
   *  @param appliedAt Database column applied_at SqlType(timestamp)
   *  @param applyScript Database column apply_script SqlType(text), Default(None)
   *  @param revertScript Database column revert_script SqlType(text), Default(None)
   *  @param state Database column state SqlType(varchar), Length(255,true), Default(None)
   *  @param lastProblem Database column last_problem SqlType(text), Default(None) */
  case class PlayEvolutionsRow(id: Int, hash: String, appliedAt: java.sql.Timestamp, applyScript: Option[String] = None, revertScript: Option[String] = None, state: Option[String] = None, lastProblem: Option[String] = None)
  /** GetResult implicit for fetching PlayEvolutionsRow objects using plain SQL queries */
  implicit def GetResultPlayEvolutionsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[PlayEvolutionsRow] = GR{
    prs => import prs._
    PlayEvolutionsRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table play_evolutions. Objects of this class serve as prototypes for rows in queries. */
  class PlayEvolutions(_tableTag: Tag) extends Table[PlayEvolutionsRow](_tableTag, "play_evolutions") {
    def * = (id, hash, appliedAt, applyScript, revertScript, state, lastProblem) <> (PlayEvolutionsRow.tupled, PlayEvolutionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(hash), Rep.Some(appliedAt), applyScript, revertScript, state, lastProblem).shaped.<>({r=>import r._; _1.map(_=> PlayEvolutionsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int4), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column hash SqlType(varchar), Length(255,true) */
    val hash: Rep[String] = column[String]("hash", O.Length(255,varying=true))
    /** Database column applied_at SqlType(timestamp) */
    val appliedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("applied_at")
    /** Database column apply_script SqlType(text), Default(None) */
    val applyScript: Rep[Option[String]] = column[Option[String]]("apply_script", O.Default(None))
    /** Database column revert_script SqlType(text), Default(None) */
    val revertScript: Rep[Option[String]] = column[Option[String]]("revert_script", O.Default(None))
    /** Database column state SqlType(varchar), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column last_problem SqlType(text), Default(None) */
    val lastProblem: Rep[Option[String]] = column[Option[String]]("last_problem", O.Default(None))
  }
  /** Collection-like TableQuery object for table PlayEvolutions */
  lazy val PlayEvolutions = new TableQuery(tag => new PlayEvolutions(tag))

  /** Entity class storing rows of table Users
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param name Database column name SqlType(varchar)
   *  @param companyId Database column company_id SqlType(int4) */
  case class UsersRow(userId: Option[Int] = None, name: String, companyId: Int)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Option[Int]], e1: GR[String], e2: GR[Int]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<?[Int], <<[String], <<[Int]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends Table[UsersRow](_tableTag, "users") {
    def * = (userId, name, companyId) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (userId, Rep.Some(name), Rep.Some(companyId)).shaped.<>({r=>import r._; _2.map(_=> UsersRow.tupled((_1, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column company_id SqlType(int4) */
    val companyId: Rep[Int] = column[Int]("company_id")
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
