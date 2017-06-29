package jl.function;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class execCommand {
    final static Logger log = LogManager.getLogger(execCommand.class.getName());

public static String  executeCommand(String command,Session session) throws JSchException,
		IOException {
    /*  jsch run the command  */
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
	channel.setCommand(command);

	channel.setInputStream(null);
	channel.setErrStream(System.err);

	final InputStream in = channel.getInputStream();

	channel.connect();

	final StringBuilder result = new StringBuilder();
	final byte[] tmp = new byte[1024];
	while (true) {
		while (in.available() > 0) {
			final int i = in.read(tmp, 0, 1024);
			if (i < 0) {
				break;
			}
			result.append(new String(tmp, 0, i));
		}
                log.info(result.toString());
		if (channel.isClosed()) {
			log.info("exit-status: " + channel.getExitStatus());
			break;
		}
		try {
			Thread.sleep(1000);
		} catch (final Exception ee) {
		}
	}

	channel.disconnect();

	return result.toString();
}

private Session getSession(String username,String hostname,Session session) throws Exception {
    try {
        ChannelExec testChannel = (ChannelExec) session.openChannel("exec");
        testChannel.setCommand("true");
        testChannel.connect();
        if(log.isDebugEnabled()) {
            log.debug("Session erfolgreich getestet, verwende sie erneut");
        }
     //   testChannel.exit();
    } catch (Throwable t) {
        log.info("Session kaputt. Baue neue.");
    //    session = getSession(user, host, 22);
     //   session.setConfig(config);
        session.connect();
    }
    return session;
}
}