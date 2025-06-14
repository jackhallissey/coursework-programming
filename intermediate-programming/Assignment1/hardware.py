#Submitted files: overview.txt, hardware.py, components.py, computers.py, testing.py (5)

class Hardware(object):
    '''
    A piece of computer hardware (either a computer itself or a component).

    Properties:
    name: str representing the name of the piece of hardware
    manufacturer: str representing the manufacturer of the piece of hardware

    Methods:
    same_manufacturer: Checks if the piece of hardware has the same manufacturer as
    another piece of hardware
    '''
    def __init__(self, name, manufacturer):
        '''
        cxtr for Hardware class
        
        Initializes Hardware instance by passing two strings representing
        the name and manufacturer of the piece of hardware.
        These are assigned to protected instance variables _name and _manufacturer.
        The _manufacturer variable should not be changed after the object is instantiated.

        Arguments:
        name: str representing the name of the piece of hardware
        manufacturer: str representing the manufacturer of the piece of hardware

        Returns:
        n/a

        Exceptions:
        TypeError if type of name or manufacturer is not str
        '''

        if type(name) is not str:
            raise TypeError("name must be of type str")
        
        if type(manufacturer) is not str:
            raise TypeError("manufacturer must be of type str")

        self._name = name
        self._manufacturer = manufacturer

    def __str__(self):
        return "%s by %s" % (self._name, self._manufacturer)

    @property
    def name(self):
        '''
        Getter for _name

        Arguments:
        n/a

        Returns:
        str representing the name of the piece of hardware

        Exceptions:
        n/a
        '''
        return self._name
    
    @name.setter
    def name(self, name):
        '''
        Setter for _name

        Arguments:
        name: str value representing the new name of the piece of hardware

        Returns:
        n/a

        Exceptions:
        TypeError if type of name is not str
        '''
        if type(name) is not str:
            raise TypeError("name must be of type str")

        self._name = name

    @property
    def manufacturer(self):
        '''
        Getter for _manufacturer

        Arguments:
        n/a

        Returns:
        str representing the manufacturer of the piece of hardware

        Exceptions:
        n/a
        '''
        return self._manufacturer
    
    def same_manufacturer(self, other):
        '''
        Checks if the piece of hardware has the same manufacturer as
        another piece of hardware provided as an argument.

        Arguments:
        other: another piece of hardware to check the manufacturer of

        Returns:
        True if the two pieces of hardware have the same manufacturer, otherwise False

        Exceptions:
        TypeError if other is not an instance of Hardware or of a subclass thereof
        '''
        if not isinstance(other, Hardware):
            raise TypeError("other must be an instance of Hardware or of a subclass thereof")

        return self._manufacturer == other._manufacturer