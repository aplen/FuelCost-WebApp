/**
 * 
 */
package io.github.plindzek;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Adam
 *
 */
class PriceDownloader {
    
    Document doc;

    PriceDownloader() {
	try {
	    doc = Jsoup.connect("https://www.autocentrum.pl/paliwa/ceny-paliw/")
		    .timeout(3000)
		    .post();
	} catch (IOException ole) {
	    // TODO Auto-generated catch block
	    ole.printStackTrace();

	}
    }

    String getAvgLpgPrice() {

	String avgLpgPrice = doc.getElementsByAttributeValueContaining("href",
		"/paliwa/ceny-paliw/lpg/").select("div").text();
	System.out.println(avgLpgPrice);
	return avgLpgPrice;

    }

    String getAvgPbPrice() {

	String avgPbPrice = doc.getElementsByAttributeValueContaining("href",
		"/paliwa/ceny-paliw/pb/").select("div").text();
	System.out.println(avgPbPrice);
	return avgPbPrice;
    }

    String getAvgPbPremiumPrice() {

	String avgpPPremiumPrice = doc.getElementsByAttributeValueContaining("href",
		"/paliwa/ceny-paliw/pb-premium/").select("div").text();
	System.out.println(avgpPPremiumPrice);
	return avgpPPremiumPrice;

    }

    String getAvgOnPrice() {

	String avgOnPrice = doc.getElementsByAttributeValueContaining("href",
		"/paliwa/ceny-paliw/on/").select("div").text();
	System.out.println(avgOnPrice);
	return avgOnPrice;

    }

    public static void main(String[] args) {

	var scrapper = new PriceDownloader();
	scrapper.getAvgLpgPrice();
	scrapper.getAvgPbPrice();
	scrapper.getAvgPbPremiumPrice();
	scrapper.getAvgOnPrice();

    }

}
