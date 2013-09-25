package org.javamoney.extras.functions;

import java.util.HashSet;
import java.util.Set;

import javax.money.MonetaryAmount;

import org.javamoney.ext.Predicate;
import org.javamoney.extras.FlavoredMonetaryAmount;


final class MonetaryAmountFlavorPredicate<T extends MonetaryAmount> implements
		Predicate<T> {

	private Set<String> flavors = new HashSet<String>();

	public MonetaryAmountFlavorPredicate(String... flavors) {
		if (flavors != null) {
			for (String flavor : flavors) {
				this.flavors.add(flavor);
			}
		}
	}

	public MonetaryAmountFlavorPredicate(Iterable<String>... flavors) {
		if (flavors != null) {
			for (Iterable<String> flavorIter : flavors) {
				for (String flavor : flavorIter) {
					this.flavors.add(flavor);
				}
			}
		}
	}

	@Override
	public boolean isPredicateTrue(T value) {
		if (!(value instanceof FlavoredMonetaryAmount)) {
			return false;
		}
		return this.flavors.contains(((FlavoredMonetaryAmount) value)
				.getAmountFlavor());
	}
}
