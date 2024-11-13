package com.dev.Backend.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String remetente;
    @Autowired
    private Configuration fmConfiguration;

    public String enviarEmailTexto(String destinatario, String titulo, String mensagem){
        try {


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(remetente);
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(titulo);
        simpleMailMessage.setText(mensagem);
        javaMailSender.send(simpleMailMessage);
        return "Email Enviado";
        } catch (Exception ex){
            return "Erro ao enviar email";
        }

    }

    public void enviarEmailTemplate(String destinatario, String titulo, Map<String, Object> propriedades){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(titulo);
            mimeMessageHelper.setFrom(remetente);
            mimeMessageHelper.setTo(destinatario);

            mimeMessageHelper.setText(getContentFromTemplate(propriedades), true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

    public String getContentFromTemplate(Map<String, Object> model) {
        StringBuilder content = new StringBuilder();
        try {
            // Corrige a extensão para .ftl
            Template template = fmConfiguration.getTemplate("email-recuperacao-codigo.flth");

            // Passa o template e o model para processTemplateIntoString
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(template, model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
