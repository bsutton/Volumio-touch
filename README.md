# Volumio-touch
A very simple (and non-functioning) attempt to create a touch interface to volumio.

The sample application just shows the UI as a design concept.
There is no working code beyond the ability to display the UI design.

To build:

mvn compile assembly:single

To run:
java -jar target/volumio-touch-jar-with-dependencies.jar

The panes displayed are intended to:

Playing:

Display the current playing song along with artist details

Queued:
display a list of songs that have been queued to play.

Play Lists:

Display a play lists that you have created and allow you to maintain them.

##Storage

Display a list of attached storage devices. This could be the local hard drive, a usb drive you have just inserted or you blue tooth attached phone.

## Settings

General controls for how the app works.

##Task

A list of Running tasks.

#3General Buttons

Natural

Returns queued music back to its originally queued order (after a shuffle)

Shuffle

Shuffles the queue

<

Replays the previous song in the queue.

>

Jumps to the next song in the queue.

Repeat

Plays the same song ov<er and again.

||

Pauses play.

< - at top of UI

Restarts the current song.

<< - a top of UI

Goes back to the previous song

>


Skips to the next song

