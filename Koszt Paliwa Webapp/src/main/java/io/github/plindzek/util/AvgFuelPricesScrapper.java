/**
 *
 */
package io.github.plindzek.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Adam
 *
 */
public class AvgFuelPricesScrapper {
	static Document doc;
    /**
     * download site with actual fuel prices
     */
    public static Document getAutocentrum() {
        try {
            doc = Jsoup.connect("https://www.autocentrum.pl/paliwa/ceny-paliw/")
                    .timeout(3000)
                    .post();
        } catch (IOException ole) {

            ole.printStackTrace();

        }
        return doc;
    }

    public static Double getAvgLpgPrice() {

        var txtAvgLpgPrice = doc.getElementsByAttributeValueContaining("href",
                "/paliwa/ceny-paliw/lpg/").select("div").text();
        var avgLpgPrice =
                Double.parseDouble(txtAvgLpgPrice.charAt(0) + "." + txtAvgLpgPrice.charAt(2) + txtAvgLpgPrice.charAt(3));
        return avgLpgPrice;

    }

    public static Double getAvgPbPrice() {

        var txtAvgPbPrice = doc.getElementsByAttributeValueContaining("href",
                "/paliwa/ceny-paliw/pb/").select("div").text();
		var avgPbPrice =
				Double.parseDouble(txtAvgPbPrice.charAt(0) + "." + txtAvgPbPrice.charAt(2) + txtAvgPbPrice.charAt(3));
		return avgPbPrice;
    }

    public static Double getAvgPbPremiumPrice() {

        var txtAvgPbPremiumPrice = doc.getElementsByAttributeValueContaining("href",
                "/paliwa/ceny-paliw/pb-premium").select("div").text();
		var avgPbPremiumPrice =
				Double.parseDouble(txtAvgPbPremiumPrice.charAt(0) + "." + txtAvgPbPremiumPrice.charAt(2) + txtAvgPbPremiumPrice.charAt(3));
        return avgPbPremiumPrice;

    }

    public static Double getAvgOnPrice() {

        var txtAvgOnPrice = doc.getElementsByAttributeValueContaining("href",
                "/paliwa/ceny-paliw/on/").select("div").text();
		var avgOnPrice =
				Double.parseDouble(txtAvgOnPrice.charAt(0) + "." + txtAvgOnPrice.charAt(2) + txtAvgOnPrice.charAt(3));
        return avgOnPrice;

    }

}
