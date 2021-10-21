package uk.brentwood.test.ganesh.utilities;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import uk.brentwood.test.ganesh.exceptions.CurrencyException;

public class CurrencyHandler {
	static NumberFormat numberFormatForGBR = NumberFormat.getCurrencyInstance(new Locale("en", "GB"));

	public static double parseCurrencyUK(String currency) {
		try {
			return numberFormatForGBR.parse(currency).doubleValue();
		} catch (ParseException e) {
			throw new CurrencyException("Unable to Parse currency:" + currency);
		}

	}

	public static String formatCurrencyUK(double currency) {
		return numberFormatForGBR.format(currency);
	}
}
