/**
 * 
 */
package com.alti.local.admin.dao.model.pk;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author syandagudita
 *
 */
public class TicketIdGenerator implements IdentifierGenerator {

	private static final String TICKETSEQ_QUERY = "SELECT SEQUENCE.NEXTVAL('LADMIN-TICKET-SEQUENCE') AS NEXT_TCK_SEQ";

	@Override
	public Serializable generate(SessionImplementor session, Object obj) {

		Connection connection = session.connection();
		String currentSeq = null;
		int seqValue = -1;
		try {

			PreparedStatement statement = connection
					.prepareStatement(TICKETSEQ_QUERY);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				seqValue = resultSet.getInt("NEXT_TCK_SEQ");
				break;
			}
			System.out.println("Current Ticket Sequence ::: " + seqValue);
			SimpleDateFormat sDateFormat = new SimpleDateFormat("YYYYMMdd");
			String dateInStr = sDateFormat.format(new Date(System
					.currentTimeMillis()));
			currentSeq = "LA" + dateInStr + String.format("%04d", seqValue);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return currentSeq;
	}

}
