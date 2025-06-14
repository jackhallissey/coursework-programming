from tkinter import Tk, Canvas
from time import sleep, perf_counter
from random import randint
from math import sqrt

class Circle(object):
    '''
    A circle which can be drawn on a Tkinter canvas.

    Properties:
    n/a

    Public Methods:
    draw: Draws the circle on a Tkinter canvas
    contains: Checks if a given point is within the circle
    '''
    def __init__(self, x, y, diameter, colour):
        '''
        cxtr for Circle class.

        Creates a Circle object which can then be drawn on a canvas.

        Arguments:
        x: int or float representing the x coordinate of the point where the circle starts
        y: int or float representing the y coordinate of the point where the circle starts
        diameter: int or float representing the diameter of the circle
        colour: str representing the fill colour of the circle

        Returns:
        n/a

        Exceptions:
        TypeError if x is not of type int or float
        TypeError if y is not of type int or float
        TypeError if diameter is not of type int or float
        TypeError if colour is not of type str
        '''
        if type(x) is not int and type(x) is not float:
            raise TypeError("x must be of type int or float")
        
        if type(y) is not int and type(y) is not float:
            raise TypeError("y must be of type int or float")
        
        if type(diameter) is not int and type(diameter) is not float:
            raise TypeError("diameter must be of type int or float")
        
        if type(colour) is not str:
            raise TypeError("colour must be of type str")
        
        self._x = x
        self._y = y
        self._diameter = diameter
        self._colour = colour

        self._radius = diameter / 2
        self._centx = x + self._radius
        self._centy = y + self._radius
        
    def draw(self, canvas):
        '''
        Draws the circle on a Tkinter canvas.

        Arguments:
        canvas: The Tkinter canvas on which to draw the circle.

        Returns:
        n/a

        Exceptions:
        TypeError if canvas is not of type Canvas
        '''
        if type(canvas) is not Canvas:
            raise TypeError("canvas must be of type Canvas")
        
        canvas.create_oval(self._x, self._y, self._x + self._diameter, self._y + self._diameter, fill=self._colour)

    def contains(self, x, y):
        '''
        Checks if a given point is within the circle.

        Arguments:
        x: int or float representing the x coordinate of the point to check
        y: int or float representing the y coordinate of the point to check

        Returns:
        True if the given point is within the circle, otherwise False

        Exceptions:
        TypeError if x is not of type int or float
        TypeError if y is not of type int or float
        '''
        if type(x) is not int and type(x) is not float:
            raise TypeError("x must be of type int or float")
        
        if type(y) is not int and type(y) is not float:
            raise TypeError("y must be of type int or float")

        distance = sqrt( (self._centx-x)**2 + (self._centy-y)**2 )

        if distance < self._radius:
            return True
        return False
    
    
        

class Interface(object):
    '''
    User interface for a game in which a circle is drawn at a random place in a canvas and the user must click on it.

    Properties:
    n/a

    Public Methods:
    n/a
    '''
    def __init__(self):
        '''
        Creates the canvas and Circle object and allows the user to click on the canvas to draw the circle.
        
        Arguments:
        n/a

        Returns:
        n/a

        Exceptions:
        n/a
        '''
        self._root = Tk()

        self._canvas = Canvas(self._root, bg="white", height=300, width=300)
        self._canvas.bind("<Button-1>", self._draw_circle)
        self._canvas.pack()

        circle_x = randint(0, 200)
        circle_y = randint(0, 200)

        self._circle = Circle(circle_x, circle_y, 100, "red")
        
        self._root.mainloop()

    def _draw_circle(self, *args):
        '''
        Waits for a random amount of time, draws the circle on the canvas, and allows the user to click on the canvas again.

        Arguments:
        n/a

        Returns:
        n/a

        Exceptions:
        n/a
        '''
        self._canvas.unbind("<Button-1>")
        
        sleep(randint(5, 10))

        self._circle.draw(self._canvas)
        self._canvas.bind("<Button-1>", self._circle_click)
        self._start_time = perf_counter()

    def _circle_click(self, event):
        '''
        Checks if the user clicked on the circle and prints the results of the game.

        Arguments:
        event: The Tkinter event for the button click on the canvas

        Returns:
        n/a

        Exceptions:
        n/a
        '''
        end = perf_counter()
        time_taken = end - self._start_time

        #Ensures this is not executed if the player clicks again before the circle is drawn
        if time_taken > 0.005:
            self._canvas.unbind("<Button-1>")

            if self._circle.contains(event.x, event.y):
                print("Hit!")
            else:
                print("Miss!")
            
            print("Time taken: %0.2f seconds" % time_taken)

if __name__ == "__main__":
    game_interface = Interface()