databaseChangeLog = {

	changeSet(author: "Smith (generated)", id: "1316667847736-1") {
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

	changeSet(author: "Smith (generated)", id: "1316667847736-2") {
		createTable(tableName: "account_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-3") {
		createTable(tableName: "picture") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "picturePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "image", type: "binary(1024000)") {
				constraints(nullable: "false")
			}

			column(name: "post_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-4") {
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

			column(name: "status", type: "varchar(1024)")
		}
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-5") {
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

	changeSet(author: "Smith (generated)", id: "1316667847736-6") {
		addPrimaryKey(columnNames: "role_id, account_id", constraintName: "account_rolePK", tableName: "account_role")
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-7") {
		createIndex(indexName: "username_unique_1316667847727", tableName: "account", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-8") {
		createIndex(indexName: "authority_unique_1316667847735", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-9") {
		addForeignKeyConstraint(baseColumnNames: "account_id", baseTableName: "account_role", constraintName: "FK410D03481D5CD069", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "account", referencesUniqueColumn: "false")
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-10") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "account_role", constraintName: "FK410D034871A5D68B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-11") {
		addForeignKeyConstraint(baseColumnNames: "post_id", baseTableName: "picture", constraintName: "FKDD905CFE841EE4B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "post", referencesUniqueColumn: "false")
	}

	changeSet(author: "Smith (generated)", id: "1316667847736-12") {
		addForeignKeyConstraint(baseColumnNames: "account_id", baseTableName: "post", constraintName: "FK3498A01D5CD069", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "account", referencesUniqueColumn: "false")
	}
}
