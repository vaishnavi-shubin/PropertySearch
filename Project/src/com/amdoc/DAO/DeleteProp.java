package com.amdoc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteProp {

	public void deleteProp(Connection conn,Scanner scc) {

		try {
			System.out.print("Enter the ID of the property to delete: ");
			int propertyIdToDelete = scc.nextInt();
			String deleteQuery = "DELETE FROM PropInfo WHERE Pid = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, propertyIdToDelete);
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println(rowsAffected + " row(s) deleted successfully. ");
			} else {
				System.out.println("No matching property found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
