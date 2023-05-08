package classes;

import abstract_classes.MultimediaElement;
import interfaces.IBrightness;

public class Image extends MultimediaElement implements IBrightness {
	public Image(String title) {
		super(title);
	}

	@Override
	public int brightnessUp() {
		return brightness < 10 ? brightness++ : brightness;
	}

	@Override
	public int brightnessDown() {
		return brightness > 0 ? brightness-- : brightness;
	}

	@Override
	public String toString() {
		return "- " + this.title + " (image)";
	}

}
