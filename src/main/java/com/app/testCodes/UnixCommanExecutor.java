package com.app.testCodes;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class UnixCommanExecutor {

    public static void main(String[] args) {
        String host = "stage2lp97.qa.paypal.com";
        String user = "sugsahu";
        String password = "sugyan@84";
        String command1 = "ls -ltr";
        try {

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");

            /**
             * SFTP file upload to Unix server.
             */
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            sftpChannel.put("C:\\Users\\sugsahu\\Downloads\\pluto_20190828_000819_riskudgopserv.jar",
                    "/x/home07/sugsahu/");
            sftpChannel.disconnect();
            
            /*Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();*/
            session.disconnect();
            System.out.println("DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
