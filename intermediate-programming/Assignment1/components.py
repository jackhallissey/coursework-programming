#Submitted files: overview.txt, hardware.py, components.py, computers.py, testing.py (5)

from hardware import Hardware

class Processor(Hardware):
    '''
    Represents the attributes of a processor (CPU). This class is a component of a computer.

    Properties:
    name: str representing the name of the processor
    manufacturer: str representing the manufacturer of the processor
    instruction_set: str representing the instruction set of the processor (e.g. x86_64, ARM)
    clock_speed: float representing the clock speed of the processor in GHz
    cores: int representing the number of cores in the processor

    Methods:
    overclock: Increases the clock speed of the processor
    faster: Checks if the processor has a higher clock speed than another processor
    '''
    def __init__(self, name, manufacturer, instruction_set, clock_speed, cores):
        '''
        cxtr for Procesor class

        Initializes Processor by passing three strings representing the name,
        manufacturer and instruction set of the processor, a float representing
        the clock speed of the processor in GHz, and an int representing the number
        of cores in the processor. These are assigned to protected instance variables
        _name, _manufacturer, _instruction_set, _clock_speed and _cores. The _manufacturer
        variable should not be changed after the object is instantiated.

        Arguments:
        name: str representing the name of the processor
        manufacturer: str representing the manufacturer of the processor
        instruction_set: str representing the instruction set of the processor (e.g. x86_64, ARM)
        clock_speed: float representing the clock speed of the processor in GHz
        cores: int representing the number of cores in the processor

        Returns:
        n/a

        Exceptions:
        TypeError if type of name, manufacturer or instruction_set is not str
        TypeError if type of clock_speed is not float
        TypeError if type of cores is not int
        '''
        if type(instruction_set) is not str:
            raise TypeError("instruction_set must be of type str")
        
        if type(clock_speed) is not float:
            raise TypeError("clock_speed must be of type float")
        
        if type(cores) is not int:
            raise TypeError("cores must be of type int")

        super().__init__(name, manufacturer)
        self._instruction_set = instruction_set
        self._clock_speed = clock_speed
        self._cores = cores

    def __str__(self):
        return "%s, %s processor, %0.1f GHz, %d cores" % (super().__str__(), self._instruction_set, self._clock_speed, self._cores)

    @property
    def instruction_set(self):
        '''
        Getter for _instruction_set

        Arguments:
        n/a

        Returns:
        str representing the instruction set of the processor

        Exceptions:
        n/a
        '''
        return self._instruction_set

    @instruction_set.setter
    def instruction_set(self, instruction_set):
        '''
        Setter for _instruction_set

        Arguments:
        instruction_set: str representing the instruction set of the processor

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of instruction_set is not str
        '''
        if type(instruction_set) is not str:
            raise TypeError("instruction_set must be of type str")
        
        self._instruction_set = instruction_set

    @property
    def clock_speed(self):
        '''
        Getter for _clock_speed

        Arguments:
        n/a

        Returns:
        float representing the clock speed of the processor in GHz

        Exceptions:
        n/a
        '''
        return self._clock_speed
    
    def overclock(self, percentage):
        '''
        Increase the clock speed of the processor by a given percentage,
        or decrease it if the percentage is negative.

        Arguments:
        percentage: the percentage by which to increase the clock speed

        Returns:
        n/a

        Exceptions:
        TypeError if type of percentage is not int
        '''
        if type(percentage) is not int:
            raise TypeError("percentage must be of type int")
        
        self._clock_speed = self._clock_speed * (1 + (percentage / 100))

    @property
    def cores(self):
        '''
        Getter for _cores

        Arguments:
        n/a

        Returns:
        int representing the number of cores in the processor

        Exceptions:
        n/a
        '''
        return self._cores

    @cores.setter
    def cores(self, cores):
        '''
        Setter for _cores

        Arguments:
        cores: int representing the number of cores in the processor

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of cores is not int
        '''
        if type(cores) is not int:
            raise TypeError("cores must be of type int")
        
        self._cores = cores

    def faster(self, other):
        '''
        Checks if the processor has a higher clock speed
        than another processor provided as an argument.

        Arguments:
        other: another processor to check the clock speed of

        Returns:
        True if self has a higher clock speed than other, otherwise False

        Exceptions:
        TypeError if other is not of type Processor
        '''
        if type(other) is not Processor:
            raise TypeError("other must of type Processor")
        
        return self._clock_speed > other._clock_speed


class Storage(Hardware):
    '''
    Represents the attributes of a storage device. This class is a component of a computer.

    Properties:
    name: str representing the name of the storage device
    manufacturer: str representing the manufacturer of the storage device
    storage_type: str representing the storage type of the storage device
    size: int representing the size of the storage device in gigabytes

    Methods:
    larger: Checks if the storage device has a greater size than another storage device
    '''
    def __init__(self, name, manufacturer, storage_type, size):
        '''
        cxtr for Storage class

        Initializes Storage instance by passing three strings representing the name,
        manufacturer and storage type of the storage device, and an int representing
        the size of the storage device in gigabytes. These are assigned to protected
        instance variables _name, _manufacturer, _storage_type and _size. The
        _manufacturer variable should not be changed after the object is instantiated.

        Arguments:
        name: str representing the name of the storage device
        manufacturer: str representing the manufacturer of the storage device
        storage_type: str representing the storage type of the storage device
        size: int representing the size of the storage device in gigabytes

        Returns:
        n/a

        Exceptions:
        TypeError if type of name, manufacturer or storage_type is not str
        TypeError if type of size is not int
        '''
        if type(storage_type) is not str:
            raise TypeError("storage_type must be of type str")
        
        if type(size) is not int:
            raise TypeError("size must be of type int")

        super().__init__(name, manufacturer)
        self._storage_type = storage_type
        self._size = size

    def __str__(self):
        return "%s, %s storage, %d GB" % (super().__str__(), self._storage_type, self._size)

    @property
    def storage_type(self):
        '''
        Getter for _storage_type

        Arguments:
        n/a

        Returns:
        str representing the storage type of the storage device

        Exceptions:
        n/a
        '''
        return self._storage_type

    @storage_type.setter
    def storage_type(self, storage_type):
        '''
        Setter for _storage_type

        Arguments:
        storage_type: str representing the storage type of the storage device

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of storage_type is not str
        '''
        if type(storage_type) is not str:
            raise TypeError("storage_type must be of type str")
        
        self._storage_type = storage_type

    @property
    def size(self):
        '''
        Getter for _size

        Arguments:
        n/a

        Returns:
        int representing the size of the storage device in gigabytes

        Exceptions:
        n/a
        '''
        return self._size

    @size.setter
    def size(self, size):
        '''
        Setter for _size

        Arguments:
        size: int representing the size of the storage device in gigabytes

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of size is not int
        '''
        if type(size) is not int:
            raise TypeError("size must be of type int")
        
        self._size = size

    def larger(self, other):
        '''
        Checks if the storage device has a greater size
        than another storage device provided as an argument.

        Arguments:
        other: another storage device to check the size of

        Returns:
        True if self has a greater size than other, otherwise False

        Exceptions:
        TypeError if other is not of type Storage
        '''
        if type(other) is not Storage:
            raise TypeError("other must of type Storage")
        
        return self._size > other._size

class Battery(Hardware):
    '''
    Represents the attributes of a battery. This class is a component of a computer.

    Properties:
    name: str representing the name of the battery
    manufacturer: str representing the manufacturer of the battery
    capacity: int representing the capacity of the battery in mAh

    Methods:
    larger_capacity: Checks if the battery has a larger capacity than another battery
    '''
    def __init__(self, name, manufacturer, capacity):
        '''
        cxtr for Battery class

        Initializes Battery by passing two strings representing the name and
        manufacturer of the battery, and an int representing the capacity of
        the battery in mAh (milliamp hours). These are assigned to protected
        instance variables _name, _manufacturer and _capacity.

        Arguments:
        name: str representing the name of the battery
        manufacturer: str representing the manufacturer of the battery
        capacity: int representing the capacity of the battery in mAh

        Returns:
        n/a

        Exceptions:
        TypeError if type of name or manufacturer is not str
        TypeError if type of capacity is not int
        '''
        if type(capacity) is not int:
            raise TypeError("capacity must be of type int")

        super().__init__(name, manufacturer)
        self._capacity = capacity

    def __str__(self):
        return "%s, %d mAh" % (super().__str__(), self._capacity)

    @property
    def capacity(self):
        '''
        Getter for _capacity

        Arguments:
        n/a

        Returns:
        int representing the capacity of the battery in mAh

        Exceptions:
        n/a
        '''
        return self._capacity

    @capacity.setter
    def capacity(self, capacity):
        '''
        Setter for _capacity

        Arguments:
        capacity: int representing the capacity of the battery in mAh

        Returns:
        n/a
        
        Exceptions:
        TypeError if type of capacity is not int
        '''
        if type(capacity) is not int:
            raise TypeError("capacity must be of type int")
        
        self._capacity = capacity

    def larger_capacity(self, other):
        '''
        Checks if the battery has a larger capacity
        than another battery provided as an argument.

        Arguments:
        other: another battery to check the capacity of

        Returns:
        True if self has a larger capacity than other, otherwise False

        Exceptions:
        TypeError if other is not of type Battery
        '''
        if type(other) is not Battery:
            raise TypeError("other must of type Battery")
        
        return self._capacity > other._capacity