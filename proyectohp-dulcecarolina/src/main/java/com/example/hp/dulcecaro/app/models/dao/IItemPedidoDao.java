package com.example.hp.dulcecaro.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.hp.dulcecaro.app.models.entity.ItemPedido;
import com.example.hp.dulcecaro.app.models.entity.Pedido;

public interface IItemPedidoDao extends CrudRepository<ItemPedido, Long>{

}
