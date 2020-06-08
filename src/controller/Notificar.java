package controller;

/*
Nosso teste para enviar email via gmail
 */
import java.util.Properties;
import javax.mail.*;
//Não funciona se não importar com o .internet depois
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class Notificar {

    //A gente pode também converter para ser uma função, recebendo o email e ficando mais facil
    public void EnviarEmail(final Mensagem m) {
        Properties propriedades = new Properties();
        //Precisa desse tipo de variavel para configurar o email
        //Aqui em baixo as configurações
        propriedades.put("mail.smtp.host", "smtp.gmail.com");
        propriedades.put("mail.smtp.socketFactory.port", 465);
        //Pelo que entendi, não precisamos configurar um servidor, podemos usar esse, que é do google
        propriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        propriedades.put("mail.smtp.auth", true);
        propriedades.put("mail.smtp.port", 465);
        //Agora temos todas as propriedades de conexão preparadas

        Session sessão = Session.getDefaultInstance(propriedades,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(m.seuEmail, m.suaSenha);
            }
        });
        //Certo, tudo isso é um parametro do sessão, é pra validar o email e começar o login no servidor
        sessão.setDebug(true);
        //Vou falar que não faço ideia do porque temos que usar o setDebug
        //Mas agora precisamos utilizar um Try e um Catch, caso dê erro no email
        try {
            Message mensagem = new MimeMessage(sessão);
            //A gente cria um corpo de mensagem, especificando o email que vai mandar
            mensagem.setFrom(new InternetAddress(m.seuEmail));
            //Remetente
            Address[] quemRecebe = InternetAddress.parse(m.emailRecebe);
            //Destinatario
            mensagem.setRecipients(Message.RecipientType.TO, quemRecebe);
            mensagem.setSubject(m.assunto); //A gente pode customizar o assunto
            mensagem.setText(m.corpo); //Corpo da mensagem
            Transport.send(mensagem);
            JOptionPane.showMessageDialog(null, "EMAIL ENVIADO COM SUCESSO");

        } catch (MessagingException e) {
            //Se por acaso der erro na mensagem, ele vem aqui e gera o erro
            JOptionPane.showMessageDialog(null, "ALGUM ERRO OCORREU");
            throw new RuntimeException(e);
        }
    }
    public void MassNot(Pacientes[] cadastro) {
        Mensagem m = new Mensagem();
        m.seuEmail = JOptionPane.showInputDialog("DIGITE SEU EMAIL");
        m.suaSenha = JOptionPane.showInputDialog("DIGITE SUA SENHA");
        for (int i = 0; i < cadastro.length; i++) {
            m.emailRecebe = cadastro[i].email;
            m.assunto = "SUA CONSULTA";
            m.corpo = "SUA CONSULTA SOBRE: " + cadastro[i].atividade + " DO DIA " + cadastro[i].data + " FOI CANCELADA";
            EnviarEmail(m);
        }
    }
}
