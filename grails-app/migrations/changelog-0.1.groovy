databaseChangeLog = {
	
	changeSet(author: "Smith (generated)", id: "1316664339401-1") {
		createTable(tableName: "account") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "accountPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-2") {
		createTable(tableName: "account_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-3") {
		createTable(tableName: "post") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "postPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "latitude", type: "varchar(255)")

			column(name: "longitude", type: "varchar(255)")

			column(name: "picture", type: "binary(10240000)")

			column(name: "status", type: "varchar(1024)")
		}
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-4") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-5") {
		addPrimaryKey(columnNames: "role_id, account_id", constraintName: "account_rolePK", tableName: "account_role")
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-6") {
		createIndex(indexName: "username_unique_1316664339394", tableName: "account", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-7") {
		createIndex(indexName: "authority_unique_1316664339400", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-8") {
		addForeignKeyConstraint(baseColumnNames: "account_id", baseTableName: "account_role", constraintName: "FK410D03481D5CD069", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "account", referencesUniqueColumn: "false")
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-9") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "account_role", constraintName: "FK410D034871A5D68B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "Smith (generated)", id: "1316664339401-10") {
		addForeignKeyConstraint(baseColumnNames: "account_id", baseTableName: "post", constraintName: "FK3498A01D5CD069", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "account", referencesUniqueColumn: "false")
	}
}
