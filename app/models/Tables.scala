package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = FollowTable.ddl ++ MemberTable.ddl ++ TweetTable.ddl

  /** Entity class storing rows of table FollowTable
    *  @param id Database column ID DBType(BIGINT), AutoInc
    *  @param followedId Database column FOLLOWED_ID DBType(VARCHAR), Length(30,true)
    *  @param memberId Database column MEMBER_ID DBType(VARCHAR), Length(30,true)
    *  @param timestampCreated Database column TIMESTAMP_CREATED DBType(TIMESTAMP)
    *  @param timestampUpdated Database column TIMESTAMP_UPDATED DBType(TIMESTAMP) */
  case class FollowTableRow(id: Long, followedId: String, memberId: String, timestampCreated: java.sql.Timestamp, timestampUpdated: java.sql.Timestamp)
  /** GetResult implicit for fetching FollowTableRow objects using plain SQL queries */
  implicit def GetResultFollowTableRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[FollowTableRow] = GR{
    prs => import prs._
      FollowTableRow.tupled((<<[Long], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table FOLLOW_TABLE. Objects of this class serve as prototypes for rows in queries. */
  class FollowTable(_tableTag: Tag) extends Table[FollowTableRow](_tableTag, "FOLLOW_TABLE") {
    def * = (id, followedId, memberId, timestampCreated, timestampUpdated) <> (FollowTableRow.tupled, FollowTableRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, followedId.?, memberId.?, timestampCreated.?, timestampUpdated.?).shaped.<>({r=>import r._; _1.map(_=> FollowTableRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID DBType(BIGINT), AutoInc */
    val id: Column[Long] = column[Long]("ID", O.AutoInc)
    /** Database column FOLLOWED_ID DBType(VARCHAR), Length(30,true) */
    val followedId: Column[String] = column[String]("FOLLOWED_ID", O.Length(30,varying=true))
    /** Database column MEMBER_ID DBType(VARCHAR), Length(30,true) */
    val memberId: Column[String] = column[String]("MEMBER_ID", O.Length(30,varying=true))
    /** Database column TIMESTAMP_CREATED DBType(TIMESTAMP) */
    val timestampCreated: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("TIMESTAMP_CREATED")
    /** Database column TIMESTAMP_UPDATED DBType(TIMESTAMP) */
    val timestampUpdated: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("TIMESTAMP_UPDATED")

    /** Primary key of FollowTable (database name FOLLOW_TABLE_PK) */
    val pk = primaryKey("FOLLOW_TABLE_PK", (id, followedId))

    /** Foreign key referencing MemberTable (database name follow_table_ibfk_1) */
    lazy val memberTableFk = foreignKey("follow_table_ibfk_1", memberId, MemberTable)(r => r.memberId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (id) (database name ID) */
    val index1 = index("ID", id, unique=true)
  }
  /** Collection-like TableQuery object for table FollowTable */
  lazy val FollowTable = new TableQuery(tag => new FollowTable(tag))

  /** Entity class storing rows of table MemberTable
    *  @param memberId Database column MEMBER_ID DBType(VARCHAR), PrimaryKey, Length(30,true)
    *  @param encryptedPassword Database column ENCRYPTED_PASSWORD DBType(VARCHAR), Length(60,true)
    *  @param mailAddress Database column MAIL_ADDRESS DBType(VARCHAR), Length(40,true)
    *  @param timestampCreated Database column TIMESTAMP_CREATED DBType(TIMESTAMP)
    *  @param timestampUpdated Database column TIMESTAMP_UPDATED DBType(TIMESTAMP) */
  case class MemberTableRow(memberId: String, encryptedPassword: String, mailAddress: String, timestampCreated: java.sql.Timestamp, timestampUpdated: java.sql.Timestamp)
  /** GetResult implicit for fetching MemberTableRow objects using plain SQL queries */
  implicit def GetResultMemberTableRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[MemberTableRow] = GR{
    prs => import prs._
      MemberTableRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table MEMBER_TABLE. Objects of this class serve as prototypes for rows in queries. */
  class MemberTable(_tableTag: Tag) extends Table[MemberTableRow](_tableTag, "MEMBER_TABLE") {
    def * = (memberId, encryptedPassword, mailAddress, timestampCreated, timestampUpdated) <> (MemberTableRow.tupled, MemberTableRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (memberId.?, encryptedPassword.?, mailAddress.?, timestampCreated.?, timestampUpdated.?).shaped.<>({r=>import r._; _1.map(_=> MemberTableRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column MEMBER_ID DBType(VARCHAR), PrimaryKey, Length(30,true) */
    val memberId: Column[String] = column[String]("MEMBER_ID", O.PrimaryKey, O.Length(30,varying=true))
    /** Database column ENCRYPTED_PASSWORD DBType(VARCHAR), Length(60,true) */
    val encryptedPassword: Column[String] = column[String]("ENCRYPTED_PASSWORD", O.Length(60,varying=true))
    /** Database column MAIL_ADDRESS DBType(VARCHAR), Length(40,true) */
    val mailAddress: Column[String] = column[String]("MAIL_ADDRESS", O.Length(40,varying=true))
    /** Database column TIMESTAMP_CREATED DBType(TIMESTAMP) */
    val timestampCreated: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("TIMESTAMP_CREATED")
    /** Database column TIMESTAMP_UPDATED DBType(TIMESTAMP) */
    val timestampUpdated: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("TIMESTAMP_UPDATED")
  }
  /** Collection-like TableQuery object for table MemberTable */
  lazy val MemberTable = new TableQuery(tag => new MemberTable(tag))

  /** Entity class storing rows of table TweetTable
    *  @param tweetId Database column TWEET_ID DBType(BIGINT), AutoInc, PrimaryKey
    *  @param text Database column TEXT DBType(VARCHAR), Length(140,true), Default(None)
    *  @param memberId Database column MEMBER_ID DBType(VARCHAR), Length(30,true)
    *  @param timestampCreated Database column TIMESTAMP_CREATED DBType(TIMESTAMP)
    *  @param timestampUpdated Database column TIMESTAMP_UPDATED DBType(TIMESTAMP) */
  case class TweetTableRow(tweetId: Long, text: Option[String] = None, memberId: String, timestampCreated: java.sql.Timestamp, timestampUpdated: java.sql.Timestamp)
  /** GetResult implicit for fetching TweetTableRow objects using plain SQL queries */
  implicit def GetResultTweetTableRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[String], e3: GR[java.sql.Timestamp]): GR[TweetTableRow] = GR{
    prs => import prs._
      TweetTableRow.tupled((<<[Long], <<?[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table TWEET_TABLE. Objects of this class serve as prototypes for rows in queries. */
  class TweetTable(_tableTag: Tag) extends Table[TweetTableRow](_tableTag, "TWEET_TABLE") {
    def * = (tweetId, text, memberId, timestampCreated, timestampUpdated) <> (TweetTableRow.tupled, TweetTableRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (tweetId.?, text, memberId.?, timestampCreated.?, timestampUpdated.?).shaped.<>({r=>import r._; _1.map(_=> TweetTableRow.tupled((_1.get, _2, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column TWEET_ID DBType(BIGINT), AutoInc, PrimaryKey */
    val tweetId: Column[Long] = column[Long]("TWEET_ID", O.AutoInc, O.PrimaryKey)
    /** Database column TEXT DBType(VARCHAR), Length(140,true), Default(None) */
    val text: Column[Option[String]] = column[Option[String]]("TEXT", O.Length(140,varying=true), O.Default(None))
    /** Database column MEMBER_ID DBType(VARCHAR), Length(30,true) */
    val memberId: Column[String] = column[String]("MEMBER_ID", O.Length(30,varying=true))
    /** Database column TIMESTAMP_CREATED DBType(TIMESTAMP) */
    val timestampCreated: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("TIMESTAMP_CREATED")
    /** Database column TIMESTAMP_UPDATED DBType(TIMESTAMP) */
    val timestampUpdated: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("TIMESTAMP_UPDATED")

    /** Foreign key referencing MemberTable (database name tweet_table_ibfk_1) */
    lazy val memberTableFk = foreignKey("tweet_table_ibfk_1", memberId, MemberTable)(r => r.memberId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TweetTable */
  lazy val TweetTable = new TableQuery(tag => new TweetTable(tag))
}