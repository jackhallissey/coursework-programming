#Submitted files: overview.txt, hardware.py, components.py, computers.py, testing.py (5)

from hardware import Hardware
from components import *

class Computer(Hardware):
    '''
    Represents the attribute and components of a computer.

    Properties:
    name: str representing the name of the computer
    manufacturer: str representing the manufacturer of the computer
    processor: Processor object representing the processor of the computer
    storage: Storage object representing the storage device of the computer
    specs: str detailing the specs of the computer

    Methods:
    same_manufacturer: Checks if the computer has the same manufacturer as
    another piece of hardware
    '''
    def __init__(self, name, manufacturer, processor, storage):
        '''
        cxtr for Computer class
        
        Initializes Computer instance by passing two strings representing
        the name and manufacturer of the computer, a Processor object representing
        the processor of the computer, and a Storage object representing the storage
        medium of the computer. These are assigned to protected instance variables _name,
        _manufacturer, _processor and _storage. The _manufacturer variable should not be
        changed after the object is instantiated.

        Arguments:
        name: str representing the name of the computer
        manufacturer: str representing the manufacturer of the computer
        processor: Processor object representing the processor of the computer
        storage: Storage object representing the storage device of the computer

        Returns:
        n/a

        Exceptions:
        TypeError if type of name or manufacturer is not str
        TypeError if type of processor is not Processor
        TypeError if type of storage is not Storage
        '''
        if type(processor) is not Processor:
            raise TypeError("processor must be of type Processor")
        
        if type(storage) is not Storage:
            raise TypeError("storage must be of type Storage")

        super().__init__(name, manufacturer)
        self._processor = processor
        self._storage = storage

    @property
    def processor(self):
        '''
        Getter for _processor

        Arguments:
        n/a

        Returns:
        Processor object representing the processor of the computer

        Exceptions:
        n/a
        '''
        return self._processor

    @processor.setter
    def processor(self, processor):
        '''
        Setter for _processor

        Arguments:
        processor: Processor object representing the new processor of the computer

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of processor is not Processor
        '''
        if type(processor) is not Processor:
            raise TypeError("processor must be of type Processor")
        
        self._processor = processor

    @property
    def storage(self):
        '''
        Getter for _storage

        Arguments:
        n/a

        Returns:
        Storage object representing the storage device of the computer

        Exceptions:
        n/a
        '''
        return self._storage

    @storage.setter
    def storage(self, storage):
        '''
        Setter for _storage

        Arguments:
        storage: Storage object representing the new storage device of the computer

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of storage is not Storage
        '''
        if type(storage) is not Storage:
            raise TypeError("storage must be of type Storage")
        
        self._storage = storage

    @property
    def specs(self):
        '''
        Provides a string representation of the specs of the computer,
        providing details of its various components.

        Arguments:
        n/a

        Returns:
        str detailing the specs of the computer

        Exceptions:
        n/a
        '''
        return "%s \nProcessor: %s \nStorage: %s" % (self, self._processor, self._storage)



class PortableDevice(Computer):
    '''
    Represents the attribute and components of a portable device.

    Properties:
    name: str representing the name of the device
    manufacturer: str representing the manufacturer of the device
    processor: Processor object representing the processor of the device
    storage: Storage object representing the storage device of the device
    battery: Battery object representing the battery of the device
    specs: str detailing the specs of the device

    Methods:
    same_manufacturer: Checks if the device has the same manufacturer as
    another piece of hardware
    '''
    def __init__(self, name, manufacturer, processor, storage, battery):
        '''
        cxtr for PortableDevice class
        
        Initializes PortableDevice instance by passing two strings representing
        the name and manufacturer of the device, a Processor object representing
        the processor of the device, a Storage object representing the storage
        medium of the device, and a Battery object representing the battery of the device.
        These are assigned to protected instance variables _name, _manufacturer, _processor,
        _storage, and _battery. The _manufacturer variable should not be changed after the
        object is instantiated.

        Arguments:
        name: str representing the name of the device
        manufacturer: str representing the manufacturer of the device
        processor: Processor object representing the processor of the device
        storage: Storage object representing the storage device of the device
        battery: Battery object representing the battery of the device

        Returns:
        n/a

        Exceptions:
        TypeError if type of name or manufacturer is not str
        TypeError if type of processor is not Processor
        TypeError if type of storage is not Storage
        TypeError if type of battery is not Battery
        '''
        if type(battery) is not Battery:
            raise TypeError("battery must be of type Battery")

        super().__init__(name, manufacturer, processor, storage)
        self._battery = battery
    
    @property
    def battery(self):
        '''
        Getter for _battery

        Arguments:
        n/a

        Returns:
        Battery object representing the battery of the device

        Exceptions:
        n/a
        '''
        return self._battery

    @battery.setter
    def battery(self, battery):
        '''
        Setter for _battery

        Arguments:
        battery: Battery object representing the new battery of the device

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of battery is not Battery
        '''
        if type(battery) is not Battery:
            raise TypeError("battery must be of type Battery")
        
        self._battery = battery

    @property
    def specs(self):
        '''
        Provides a string representation of the specs of the computer,
        providing details of its various components.

        Arguments:
        n/a

        Returns:
        str detailing the specs of the computer

        Exceptions:
        n/a
        '''
        return "%s \nBattery: %s" % (super().specs, self._battery)



class Laptop(PortableDevice):
    '''
    Represents the attribute and components of a laptop.

    Properties:
    name: str representing the name of the laptop
    manufacturer: str representing the manufacturer of the laptop
    processor: Processor object representing the processor of the laptop
    storage: Storage object representing the storage device of the laptop
    battery: Battery object representing the battery of the laptop
    keyboard_layout: str representing the keyboard layout of the laptop
    specs: str detailing the specs of the laptop

    Methods:
    same_manufacturer: Checks if the laptop has the same manufacturer as
    another piece of hardware
    '''
    def __init__(self, name, manufacturer, processor, storage, battery, keyboard_layout):
        '''
        cxtr for Laptop class
        
        Initializes Laptop instance by passing two strings representing
        the name and manufacturer of the laptop, a Processor object representing
        the processor of the laptop, a Storage object representing the storage
        medium of the laptop, a Battery object representing the battery of the laptop, and a
        string representing the keyboard layout of the laptop. These are assigned to protected
        instance variables _name, _manufacturer, _processor, _storage, _battery, and _keyboard_layout.
        The _manufacturer variable should not be changed after the object is instantiated.

        Arguments:
        name: str representing the name of the laptop
        manufacturer: str representing the manufacturer of the laptop
        processor: Processor object representing the processor of the laptop
        storage: Storage object representing the storage device of the laptop
        battery: Battery object representing the battery of the laptop
        keyboard_layout: str representing the keyboard layout of the laptop

        Returns:
        n/a

        Exceptions:
        TypeError if type of name, manufacturer or keyboard_layout is not str
        TypeError if type of processor is not Processor
        TypeError if type of storage is not Storage
        TypeError if type of battery is not Battery
        '''

        if type(keyboard_layout) is not str:
            raise TypeError("keyboard_layout must be of type str")
        
        super().__init__(name, manufacturer, processor, storage, battery)
        self._keyboard_layout = keyboard_layout

    @property
    def keyboard_layout(self):
        '''
        Getter for _keyboard_layout

        Arguments:
        n/a

        Returns:
        str representing the keyboard layout of the laptop

        Exceptions:
        n/a
        '''
        return self._keyboard_layout

    @keyboard_layout.setter
    def keyboard_layout(self, keyboard_layout):
        '''
        Setter for _keyboard_layout

        Arguments:
        keyboard_layout: str representing the new keyboard layout of the laptop

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of keyboard_layout is not str
        '''
        if type(keyboard_layout) is not str:
            raise TypeError("keyboard_layout must be of type str")
        
        self._keyboard_layout = keyboard_layout

    @property
    def specs(self):
        '''
        Provides a string representation of the specs of the computer,
        providing details of its various components.

        Arguments:
        n/a

        Returns:
        str detailing the specs of the computer

        Exceptions:
        n/a
        '''
        return "%s \nKeyboard Layout: %s" % (super().specs, self._keyboard_layout)



class Phone(PortableDevice):
    '''
    Represents the attribute and components of a laptop.

    Properties:
    name: str representing the name of the laptop
    manufacturer: str representing the manufacturer of the laptop
    processor: Processor object representing the processor of the laptop
    storage: Storage object representing the storage device of the laptop
    battery: Battery object representing the battery of the laptop
    mobile_standard: str representing the mobile standard of the phone
    specs: str detailing the specs of the laptop

    Methods:
    same_manufacturer: Checks if the laptop has the same manufacturer as
    another piece of hardware
    '''
    def __init__(self, name, manufacturer, processor, storage, battery, mobile_standard):
        '''
        cxtr for Phone class
        
        Initializes Phone instance by passing two strings representing
        the name and manufacturer of the phone, a Processor object representing
        the processor of the phone, a Storage object representing the storage
        medium of the phone, a Battery object representing the battery of the phone, and a
        string representing the mobile standard of the phone. These are assigned to protected
        instance variables _name, _manufacturer, _processor, _storage, _battery, and _mobile_standard.
        The _manufacturer variable should not be changed after the object is instantiated.

        Arguments:
        name: str representing the name of the phone
        manufacturer: str representing the manufacturer of the phone
        processor: Processor object representing the processor of the phone
        storage: Storage object representing the storage device of the phone
        battery: Battery object representing the battery of the phone
        mobile_standard: str representing the mobile standard of the phone

        Returns:
        n/a

        Exceptions:
        TypeError if type of name, manufacturer or mobile_standard is not str
        TypeError if type of processor is not Processor
        TypeError if type of storage is not Storage
        TypeError if type of battery is not Battery
        '''

        if type(mobile_standard) is not str:
            raise TypeError("mobile_standard must be of type str")
        
        super().__init__(name, manufacturer, processor, storage, battery)
        self._mobile_standard = mobile_standard

    @property
    def mobile_standard(self):
        '''
        Getter for _mobile_standard

        Arguments:
        n/a

        Returns:
        str representing the mobile standard of the phone

        Exceptions:
        n/a
        '''
        return self._mobile_standard

    @mobile_standard.setter
    def mobile_standard(self, mobile_standard):
        '''
        Setter for _mobile_standard

        Arguments:
        mobile_standard: str representing the new mobile standard of the phone

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of mobile_standard is not str
        '''
        if type(mobile_standard) is not str:
            raise TypeError("mobile_standard must be of type str")
        
        self._mobile_standard = mobile_standard

    @property
    def specs(self):
        '''
        Provides a string representation of the specs of the computer,
        providing details of its various components.

        Arguments:
        n/a

        Returns:
        str detailing the specs of the computer

        Exceptions:
        n/a
        '''
        return "%s \nMobile Standard: %s" % (super().specs, self._mobile_standard)

