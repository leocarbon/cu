# version.md


### releases

###### 0.5.8.0 (1.28.15)
* fixed logging bug where the program creates a logging file even when logging is disabled
	
###### 0.5.7 (9.28.14)
* Option for logging (no logging in default)
* Removed version text in About.java. It was becoming an unnecessary hassle.
	
###### 0.5.6.1 (8.31.14)
* updated About.java version text

###### 0.5.6.0
* Color Utility is now released!
	*  versioning will be a little different from now
* finished up internationalization for Easyview.java and Options.java


### gamma(γ)

###### 0.γ5.5.0 (8.30.14)
* finished options window
	* removed background color settings
* tidied things up
	* removed the too-buggy-and-hard-to-make-it-work Window menu
		
###### 0.γ5.4.0 (8.24.14)
* the menu bar is now language-independent
* minor fixes
	
###### 0.γ5.3.1 (8.22.14)
* Fixed miniscule if-statement bug in AverageColor.java
	
###### 0.γ5.3.0 (8.20.14)
* JDK 1.8
	* Multicatch, lambda expressions, and String switch-case everywhere!
* Options remodeling in work.
* Mac OS ‘two About windows’ bug has been fixed (magically!)
	
###### 0.γ5.2.0 (8.15.14)
* Organized classes
* Reintroduced old Easyview foreground color setting algorithm
* Options fix
	* Background color changing is now finished (But maybe some more bugs)
	* Component visibility settings fixed
* Can’t resize program window anymore... (will be able to in the future)

###### 0.γ5.1.0 (8.11~12.14)
* More Copy/Paste functions.
* Easyview is now a separate Object!
* Localization for American English and Korean (translator volunteers welcome!)
	* Changed some names and made logging less hard on the way
* Background color changing is back! (Thanks to [843806](https://community.oracle.com/people/843806?customTheme=otn): [https://community.oracle.com/thread/1354255?start=0&tstart=0](https://community.oracle.com/thread/1354255?start=0&tstart=0))
	* I really works now!
		
###### 0.γ5.0.1 (8.10.14)
* I've decided to use Gamma(γ), the Greek alphabet next to Beta(β). I also added some Greek characters instead of the plain old 'a' and 'b.'

###### 0.γ5.0.0
* New GUI layout.
* Slight code optimization and tidying
	* Removed unnecessary files (/components/)
* The menu bar now works!
	* Next update will rework the options menu.
* Getting ready for internationalization.


### beta(β)

###### 0.β4.0.0 (?.??.14)
* I don't know.

###### 0.β3.1.1 (1.19.14)
* Updated About.java

###### 0.β3.1.0 (1.15.14)
* org.apache.log4j for logging
	

###### 0.β3.0.0 (8.18.13)
* Changed some names
* Disabled locking of panel visibility
    * For future full-screen function
	* Easy View color data value (a.k.a. 'text') visibility toggle

	* Added background color changing slider for contrast on some grayscale colors displayed on Easy View
	* Added Toning Colors [com.leocarbonate.cu.models.ToneColor.java]

	* Sliders in Color Fading [models.ScrollColor.java] have ticks for accurate values


###### 0.β2.2.0 (8.6.13)
* Fixed minor color displaying flaw

###### 0.β2.1.0 (7.21.13)
* Windows flaw fixed 
* Temporarily disabled changing look and feel

###### 0.β2.0.0 (7.20.13)
* Ready for Beta teasing
* 한국 정보올림피아드 공모전 출전
* Built Color Uility.app for Mac OS X
* removed com.mkyong.core.OSValidator.java and added custom OSValidator code to
		com.leocarbonate.cu.utilites.OSValidator.java
* created com.leocarbonate.cu.models for com.leocarbonate.cu.ColorUtility.ccc's AbstractColorChooserPanels
* com.leocarbonate.cu.utilities.Functions.java for miscellaneous functions

* GUI structure is now JTabbedPane
* About pane inspired by Color Mixer [url](https://github.com/jangdan/Color-Mixer)
* Settings pane - will be updated


### alpha(α)
###### 0.α1.1.1 (7.15.13)
* Java Example added as 'components.FileChooserDemo2Project'
* mkyong.com OSValidator added
* ActionHandler.java
* DigitalEyedropper extends SwingWorker
* Added Look&Feel Editing
* EasyView inspired by ColorMixer [url](https://github.com/leocarbon/cm)
* Average Color [url](http://stackoverflow.com/a/12408627/2580875)

###### 0.α1.1.0
* Basic Color Chooser with JColorChooser
* Borders for JPanels
* DigitalEyedropper from Digital.Eyedropper
	* Not working yet