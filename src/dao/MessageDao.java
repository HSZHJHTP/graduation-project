package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import entity.Inbox;
import entity.Login;
import entity.Outbox;

public class MessageDao {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	Login login = new Login();

	public void getConnection() {

		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取连接对象
			connection = DriverManager.getConnection(

			"jdbc:mysql://localhost:3306/graduation project", "root", "123");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Login> findLogin() {
		List<Login> list = new ArrayList<Login>();

		try {
			getConnection();
			// 3.创建Statement
			statement = connection.createStatement();
			// 4.准备Sql
			String sql = "SELECT name,password FROM login;";
			// 5.执行Sql语句
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Login login = new Login();
				// login.setId(resultSet.getInt("id"));
				login.setName(resultSet.getString("name"));
				login.setPassword(resultSet.getString("password"));
				list.add(login);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		}
		return list;
	}

	public List<Inbox> findInbox() {
		List<Inbox> list = new ArrayList<Inbox>();

		try {
			getConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM inbox;";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Inbox inbox = new Inbox();
				inbox.setId(resultSet.getInt("id"));
				inbox.setTelephoneNumber(resultSet.getString("telephoneNumber"));
				inbox.setSmsContent(resultSet.getString("smsContent"));
				list.add(inbox);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		}
		return list;
	}

	public List<Outbox> findOutbox() {
		List<Outbox> list = new ArrayList<Outbox>();

		try {
			getConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM outbox;";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Outbox outbox = new Outbox();
				outbox.setId(resultSet.getInt("id"));
				outbox.setTelephoneNumber(resultSet
						.getString("telephoneNumber"));
				outbox.setSmsContent(resultSet.getString("smsContent"));
				list.add(outbox);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		}
		return list;
	}

	public int insertLogin(Login login) {
		int rs = 0;
		try {

			getConnection();
			String sql = "INSERT INTO login (name,password) VALUES(?,?);";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, login.getName());
			preparedStatement.setString(2, login.getPassword());
			rs = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;

	}

	public int insertInBox(Inbox inbox) {
		int rs = 0;
		try {

			getConnection();
			String sql = "INSERT INTO inbox (name,password) VALUES(?,?);";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, inbox.getTelephoneNumber());
			preparedStatement.setString(2, inbox.getSmsContent());
			rs = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;

	}

	public int insertOutBox(Outbox outbox) {
		int rs = 0;
		try {

			getConnection();
			String sql = "INSERT INTO outbox(name,password) VALUES(?,?);";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, outbox.getTelephoneNumber());
			preparedStatement.setString(2, outbox.getSmsContent());
			rs = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;

	}

	public void delete(Outbox outbox) {

		try {
			getConnection();
			String sql = "DELETE FROM outbox WHERE id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, outbox.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		}
	}

	public void delete(Inbox inbox) {

		try {
			getConnection();
			String sql = "DELETE FROM inbox WHERE id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, inbox.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		}
	}

	public Outbox findOutBoxById(int id) {
		Outbox outbox = new Outbox();

		try {
			getConnection();
			String sql = "SELECT smsContent FROM outbox WHERE id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				outbox.setSmsContent(resultSet.getNString("smsContent"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		}
		return outbox;
	}

	public Inbox findInBoxById(int id) {
		Inbox inbox = new Inbox();

		try {
			getConnection();
			String sql = "SELECT smsContent FROM inbox WHERE id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				inbox.setSmsContent(resultSet.getNString("smsContent"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		}
		return inbox;
	}

	// public List<Student> findByCondition(Student condition) {
	// List<Student> list = new ArrayList<Student>();
	// String sql = "SELECT * FROM studo WHERE 1=1";
	// if (!condition.getName().equals("")) {
	// sql += " and name like  '%" + condition.getName() + "%'";
	//
	// }
	// if (!condition.getSex().equals("")) {
	//
	// sql += " and sex = '" + condition.getSex() + "'";
	//
	// }
	// if (condition.getAge() > 0) {
	// sql += " and age = '" + condition.getAge() + "'";
	// }
	// try {
	// getConnection();
	// statement = connection.createStatement();
	//
	// resultSet = statement.executeQuery(sql);
	// while (resultSet.next()) {
	// Student student = new Student();
	// student.setId(resultSet.getInt("id"));
	// student.setName(resultSet.getString("name"));
	// student.setSex(resultSet.getString("sex"));
	// student.setAge(resultSet.getInt("age"));
	// student.setId(resultSet.getInt("id"));
	// list.add(student);
	//
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (statement != null) {
	// try {
	// statement.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// if (connection != null) {
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// if (resultSet != null) {
	// try {
	// resultSet.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }
	//
	// }
	// return list;
	// }
	//

	// public int update(Student student) {
	// int rs = 0;
	// try {
	//
	// getConnection();
	// String sql = "UPDATE studo SET name=?,sex=?,age=? WHERE id=? ;";
	// preparedStatement = connection.prepareStatement(sql);
	//
	// preparedStatement.setString(1, student.getName());
	// preparedStatement.setString(2, student.getSex());
	// preparedStatement.setInt(3, student.getAge());
	// preparedStatement.setInt(4, student.getId());
	// rs = preparedStatement.executeUpdate();
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (preparedStatement != null) {
	// try {
	// preparedStatement.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// if (connection != null) {
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// return rs;
	//
	// }
	//

}
