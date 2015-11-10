/**
 * 
 */
package com.alti.local.admin.dao.model.pk;

import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author syandagudita
 *
 */
public class TicketIdGenerator  implements IdentifierGenerator {
	
	private static final String TICKETSEQ_QUERY = "";
	static {
		
	}

	@Override
	public Serializable generate(SessionImplementor session, Object obj) {
		
		Connection connection = session.connection();
		String currentSeq = null;
		int seqValue = 7;
		try {
			/*
			PreparedStatement statement = connection.prepareStatement(TICKETSEQ_QUERY);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				seqValue = resultSet.getInt("NEXTVAL");
				break;
			}*/
			
			SimpleDateFormat sDateFormat = new SimpleDateFormat("YYYYMMdd");
			String dateInStr = sDateFormat.format(new Date(System.currentTimeMillis()));
			currentSeq = "LA" + dateInStr + String.format("%03d", seqValue);;
			System.out.println("dateInStr  :: "+dateInStr + "  lenght :: "+dateInStr.length());
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return currentSeq;
	}
	
	public static void main(String... strings) {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("YYYYMMdd");
		String dateInStr = sDateFormat.format(new Date(System.currentTimeMillis()));
		System.out.println(">>>>>>. "+dateInStr);
		int seqValue = 1;
		dateInStr = "LA" + dateInStr + String.format("%03d", seqValue);;
		System.out.println("dateInStr  :: "+dateInStr + "  lenght :: "+dateInStr.length());
	
	}
}
