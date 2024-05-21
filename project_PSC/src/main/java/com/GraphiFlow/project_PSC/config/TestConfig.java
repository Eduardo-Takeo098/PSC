package com.GraphiFlow.project_PSC.config;

import com.GraphiFlow.project_PSC.entities.*;
import com.GraphiFlow.project_PSC.entities.enums.OrderStatus;
import com.GraphiFlow.project_PSC.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserAdmRepository userAdmRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Área Técnica 01");
        Category cat2 = new Category(null, "Área Técnica 02");
        Category cat3 = new Category(null, "Área Técnica 03");

        Task t1 = new Task(null, "Análise de Dados de Vendas Mensais", "Esta tarefa envolve a análise dos dados de vendas mensais para identificar padrões, tendências e insights úteis para a tomada de decisões estratégicas.", "");
        Task t2 = new Task(null, "Desenvolvimento de Conteúdo para Mídias Sociais", "Nesta tarefa, você será responsável por criar conteúdo envolvente e relevante para as mídias sociais da empresa.", "");
        Task t3 = new Task(null, "Teste de Software de Aplicativo Móvel", "Este trabalho envolve a execução de testes de software em um aplicativo móvel para garantir sua funcionalidade, usabilidade e desempenho.", "");
        Task t4 = new Task(null, "Implementação de Estratégia de Marketing Digital", "Nesta tarefa, você será encarregado de implementar uma estratégia de marketing digital para promover produtos ou serviços da empresa.", "");
        Task t5 = new Task(null, "Desenvolvimento de Protótipo de Produto", "Nesta tarefa, você será responsável por criar protótipos de produtos para validar ideias, conceitos ou funcionalidades antes da produção em larga escala.", "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        taskRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));

        t1.getCategories().add(cat2);
        t2.getCategories().add(cat1);
        t2.getCategories().add(cat3);
        t3.getCategories().add(cat3);
        t4.getCategories().add(cat3);
        t5.getCategories().add(cat2);

        taskRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));

        User u1 = new User(null, "Pedro", 43, 'M', "pedro098@gmail.com", "111.111.111.12", "Senha");
        User u2 = new User(null, "João", 23, 'M', "joão098@gmail.com", "111.111.111.13", "Senha");

        UserAdm uadm1 = new UserAdm(null, "Adm", "adm@gmail.com","Admin");

        Order o1 = new Order(null, Instant.parse("2024-06-20T19:53:07Z"), OrderStatus.CANCELED, uadm1);
        Order o2 = new Order(null, Instant.parse("2024-07-21T03:42:10Z"), OrderStatus.WAITING_DELIVERY, uadm1);
        Order o3 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.DELIVERED, uadm1);
        Order o4 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.DELIVERED, uadm1);
        Order o5 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.DELIVERED, uadm1);

        userAdmRepository.saveAll(Arrays.asList(uadm1));
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
    }
}
