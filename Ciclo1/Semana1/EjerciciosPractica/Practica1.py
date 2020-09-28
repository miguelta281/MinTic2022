import math

def SumaMaximoMinimo (elemento1:int, elemento2:int, elemento3:int, elemento4:int, elemento5:int):
    maximo = max(elemento1,elemento2, elemento3,elemento4,elemento5)
    minimo = min(elemento1,elemento2, elemento3,elemento4,elemento5)
    return maximo + minimo

def SumaDecimales (numero1:float, numero2:float):
    parte_decimal1, parte_entera1 = math.modf(numero1)
    parte_decimal2, parte_entera2 = math.modf(numero2)
    return "La suma de la parte decimal de {} y {} es {}".format(numero1,numero2,parte_decimal1 + parte_decimal2)

def PerimetroArea ():
    radio = float(input("Ingrese el radio de la circunferencia"))
    perimetro = 2 * math.pi * radio
    area = math.pi * (radio ** 2)
    return "Para una circubferencia con radio {}, el perímetro es {} y el área es {}".format(radio,perimetro,area)

def suma (numero1, numero2):
    return numero1 + numero2

def resta (numero1, numero2):
    return numero1 - numero2

def multiplicacion (numero1,numero2):
    return numero1 * numero2

def division (numero1,numero2):
    return numero1 / numero2

def SRMD (numero1,numero2):
    S = suma (numero1, numero2)
    R = resta (numero1, numero2)
    M = multiplicacion (numero1,numero2)
    D = division (numero1,numero2)
    return "Con los números {} y {}, se tiene: suma {}, resta {}, multiplicación {}, división {}".format(numero1, numero2, S, R, M , D)

def AreaTriangulo ():
    print ("Ingrese los 3 lados del triángulo")
    lado1 = float(input("Ingrese el lado 1 del triangulo "))
    lado2 = float(input("Ingrese el lado 2 del triangulo "))
    lado3 = float(input("Ingrese el lado 3 del triangulo "))
    semiPerimetro = (lado1 + lado2 + lado3) / 2
    area = round((semiPerimetro * (semiPerimetro - lado1)* (semiPerimetro - lado2) * (semiPerimetro - lado3)) ** (1/2),2)
    return "El área del triángulo de lados {}, {},{} es {}".format(lado1,lado2,lado3,area)