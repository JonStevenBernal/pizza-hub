package com.pizzaHub.pizzahub.persitence.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idOrder;

	private Integer idItem;

	@Override
	public int hashCode() {
		return Objects.hash(idItem, idOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof OrderItemId)) {
			return false;
		}
		OrderItemId other = (OrderItemId) obj;
		return Objects.equals(idItem, other.idItem) && Objects.equals(idOrder, other.idOrder);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof OrderItemId that)) {
//			return false;
//		}
//		return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(idOrder, idItem);
//	}

}
