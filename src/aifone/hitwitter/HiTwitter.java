package aifone.hitwitter;

import aifone.IAiFoneSaida;

public class HiTwitter implements IHiTwitter {

	private IAiFoneSaida aifone;

	public HiTwitter(IAiFoneSaida aifone) {
		this.aifone = aifone;
	}
}
