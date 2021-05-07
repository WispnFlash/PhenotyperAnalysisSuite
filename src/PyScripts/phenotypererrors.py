class DatabaseError(Exception):
	def __init__(self, message="No available database connection"):
		self.message = message
		super().__init__(self.message)

class InvestigatorError(Exception):
	def __init__(self, message="Invalid Investigator"):
		self.message = message
		super().__init__(self.message)
	
class CageCardError(Exception):
	def __init__(self, message="Invalid Cage Card #"):
		self.message = message
		super().__init__(self.message)
	
class AnimalIDError(Exception):
	def __init__(self, message="Invalid AnimalID"):
		self.message = message
		super().__init__(self.message)
	
class TreatmentError(Exception):
	def __init__(self, message="Invalid Treatment"):
		self.message = message
		super().__init__(self.message)
	
class GenderError(Exception):
	def __init__(self, message="Invalid Gender"):
		self.message = message
		super().__init__(self.message)
	
class DateOfBirthError(Exception):
	def __init__(self, message="Invalid Date of Birth"):
		self.message = message
		super().__init__(self.message)
		
class PhenNumberError(Exception):
	def __init__(self, message="Invalid Phenotyper #"):
		self.message = message
		super().__init__(self.message)
	
class PreWeightError(Exception):
	def __init__(self, message="Invalid PreWeight"):
		self.message = message
		super().__init__(self.message)
	
class PostWeightError(Exception):
	def __init__(self, message="Invalid PostWeight"):
		self.message = message
		super().__init__(self.message)
	
class StrainError(Exception):
	def __init__(self, message="Invalid Strain"):
		self.message = message
		super().__init__(self.message)