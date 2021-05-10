package com.wsystec.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wsystec.cursomc.domain.Categoria;
import com.wsystec.cursomc.domain.Cidade;
import com.wsystec.cursomc.domain.Cliente;
import com.wsystec.cursomc.domain.Endereco;
import com.wsystec.cursomc.domain.Estado;
import com.wsystec.cursomc.domain.ItemPedido;
import com.wsystec.cursomc.domain.Pagamento;
import com.wsystec.cursomc.domain.PagamentoComBoleto;
import com.wsystec.cursomc.domain.PagamentoComCartao;
import com.wsystec.cursomc.domain.Pedido;
import com.wsystec.cursomc.domain.Produto;
import com.wsystec.cursomc.domain.enuns.EstadoPagamento;
import com.wsystec.cursomc.domain.enuns.TipoCliente;
import com.wsystec.cursomc.repositories.CategoriaRepository;
import com.wsystec.cursomc.repositories.CidadeRepository;
import com.wsystec.cursomc.repositories.ClienteRepository;
import com.wsystec.cursomc.repositories.EnderecoRepository;
import com.wsystec.cursomc.repositories.EstadoRepository;
import com.wsystec.cursomc.repositories.ItemPedidoRepository;
import com.wsystec.cursomc.repositories.PagamentoRepository;
import com.wsystec.cursomc.repositories.PedidoRepository;
import com.wsystec.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Vestuario");
		Categoria cat4 = new Categoria(null, "Eletronicos");
		Categoria cat5 = new Categoria(null, "Cama mesa e banho");
		Categoria cat6 = new Categoria(null, "Servicos");
		Categoria cat7 = new Categoria(null, "Livraria");
		Categoria cat8 = new Categoria(null, "Estudos");
		Categoria cat9 = new Categoria(null, "Diversao");
		Categoria cat10 = new Categoria(null, "Infantil");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "TV", 3000.00);
		Produto p3 = new Produto(null, "Mesa", 200.00);
		Produto p4 = new Produto(null, "Cadeira Escritorio", 300.00);
		Produto p5 = new Produto(null, "Notebook", 1200.00);
		Produto p6 = new Produto(null, "Celular", 2200.00);
		Produto p7 = new Produto(null, "Roçadeira", 250.00);
		Produto p8 = new Produto(null, "Motosserra", 480.00);
		Produto p9 = new Produto(null, "Impressora", 260.00);
		Produto p10 = new Produto(null, "Shampoo", 20.00);
		Produto p11 = new Produto(null, "Toalhas", 25.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p2, p5, p7));
		cat4.getProdutos().addAll(Arrays.asList(p8, p6, p7));
		cat5.getProdutos().addAll(Arrays.asList(p1, p3, p5));
		cat6.getProdutos().addAll(Arrays.asList(p6, p7));
		cat7.getProdutos().addAll(Arrays.asList(p9, p10));
		cat8.getProdutos().addAll(Arrays.asList(p7, p5, p8, p9, p6));
		cat9.getProdutos().addAll(Arrays.asList(p4, p8, p11));
		cat10.getProdutos().addAll(Arrays.asList(p4, p5, p6, p10, p11));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat9, cat10));
		p5.getCategorias().addAll(Arrays.asList(cat3, cat5, cat8, cat10));
		p6.getCategorias().addAll(Arrays.asList(cat4, cat6, cat8, cat10));
		p7.getCategorias().addAll(Arrays.asList(cat3, cat4, cat6, cat8));
		p8.getCategorias().addAll(Arrays.asList(cat4, cat8, cat9));
		p9.getCategorias().addAll(Arrays.asList(cat7, cat8));
		p10.getCategorias().addAll(Arrays.asList(cat10, cat7));
		p11.getCategorias().addAll(Arrays.asList(cat9, cat10));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("999256570", "99207454"));

		Endereco e1 = new Endereco(null, "Rua Flores", "20", "Apto  303", "Jardim", "84174639", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Matos", "21", "Apto  304", "Araucaria", "84174639", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);

		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
