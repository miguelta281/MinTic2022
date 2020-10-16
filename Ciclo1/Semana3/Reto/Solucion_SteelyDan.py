# -*- coding: utf-8 -*-
"""
Created on Tue Oct 13 12:32:47 2020

@author: Santiago
"""

def ruteo(distancias:dict, ruta_inicial:list)->dict: 
    mejoro = True 
    primeraL = ruta_inicial[0:]
    #a verificar que las entradas sean adecuadas 
    for x in distancias:
    
        for i in range(0,len(x)-1) : 
            for j in range(i+1,len(x)):
                if x[i] == x[j]: 
                    if distancias[(x[i],x[j])] != 0 or distancias[x] < 0:
                        mejoro = False
                        return "Por favor revisar los datos de entrada."
            
         

        
    
    
    while mejoro : 
        suma_p = 0
        
        for num in range(1,len(ruta_inicial)): 
            suma_p += distancias[(ruta_inicial[num-1],ruta_inicial[num])]
        
        suma_c = suma_p
        for i in range(1, len(ruta_inicial)-1): 
            
            
            for j in range(i+1,len(ruta_inicial)-1): 
                suma_r = 0 
                lista_r = ruta_inicial[:]
                temp = lista_r[i]
                lista_r[i] = lista_r[j]
                lista_r[j] = temp 
                
                for num in range(1,len(ruta_inicial)): 
                    suma_r += distancias[(lista_r[num-1],lista_r[num])] 
                        
            
                if suma_r < suma_c: 
                    suma_c = suma_r
                    mejor_intercambio = lista_r[:]
                
         
            
        if suma_c < suma_p: 
            ruta_inicial = mejor_intercambio[:]
            suma_p = suma_c 
            mejoro = True 
# =============================================================================
#         if suma_p < suma_def : 
#             mejoro = True
# =============================================================================
            
        else: 
            mejoro = False
    lista = []
    for elemento in range(0,len(ruta_inicial)): 
        if elemento == len(ruta_inicial)-1:
            lista.append("{}".format(ruta_inicial[elemento]))
        else:
            lista.append("{}-".format(ruta_inicial[elemento]))
            
        
    retorno_f = {'ruta':''.join(lista) ,'distancia': suma_p}        
    
    return retorno_f
        
        
        
distancias = {('H', 'H'): 0, ('H', 'A'): 60, ('H', 'B'): 202, ('H', 'C'): 206, ('H', 'D'): 40, ('H', 'E'): 27,
('A', 'H'): 72, ('A', 'A'): 0, ('A', 'B'): 135, ('A', 'C'): 150, ('A', 'D'): 240, ('A', 'E'): 117,
('B', 'H'): 188, ('B', 'A'): 166, ('B', 'B'): 0, ('B', 'C'): 149, ('B', 'D'): 126, ('B', 'E'): 199,
('C', 'H'): 39, ('C', 'A'): 19, ('C', 'B'): 123, ('C', 'C'): 0, ('C', 'D'): 206, ('C', 'E'): 19,
('D', 'H'): 45, ('D', 'A'): 14, ('D', 'B'): 110, ('D', 'C'): 95, ('D', 'D'): 0, ('D', 'E'): 31,
('E', 'H'): 36, ('E', 'A'): 179, ('E', 'B'): 235, ('E', 'C'): 106, ('E', 'D'): 25, ('E', 'E'): 0}


distancias2 = {('H', 'H'): 666, ('H', 'A'): 21, ('H', 'B'): 57, ('H', 'C'): 58, ('H', 'D'): 195, ('H', 'E'): 245, ('H', 'F'): 241,
('A', 'H'): 127, ('A', 'A'): 0, ('A', 'B'): 231, ('A', 'C'): 113, ('A', 'D'): 254, ('A', 'E'): 179, ('A', 'F'): 41,
('B', 'H'): 153, ('B', 'A'): 252, ('B', 'B'): 0, ('B', 'C'): 56, ('B', 'D'): 126, ('B', 'E'): 160, ('B', 'F'): 269,
('C', 'H'): 196, ('C', 'A'): 128, ('C', 'B'): 80, ('C', 'C'): 0, ('C', 'D'): 136, ('C', 'E'): 37, ('C', 'F'): 180,
('D', 'H'): 30, ('D', 'A'): 40, ('D', 'B'): 256, ('D', 'C'): 121, ('D', 'D'): 0, ('D', 'E'): 194, ('D', 'F'): 109,
('E', 'H'): 33, ('E', 'A'): 144, ('E', 'B'): 179, ('E', 'C'): 114, ('E', 'D'): 237, ('E', 'E'): 0, ('E', 'F'): 119,
('F', 'H'): 267, ('F', 'A'): 61, ('F', 'B'): 79, ('F', 'C'): 39, ('F', 'D'): 135, ('F', 'E'): 55, ('F', 'F'): 0}

lista2 = ['H', 'A', 'B', 'C', 'D', 'E', 'F', 'H']
lista = ['H', 'B', 'E', 'A', 'C', 'D', 'H']

print(ruteo(distancias,lista))
print(ruteo(distancias2,lista2))


# =============================================================================
# print(distancias.keys())
# =============================================================================

# =============================================================================
# for x in distancias:
#     
#     for i in range(0,len(x)-1) : 
#         for j in range(i+1,len(x)):
#             if x[i] == x[j]: 
#                 if distancias[(x[i],x[j])] != 0 or distancias[x] < 0:
#                     print(x)
#         
#             
# =============================================================================
        
        


                
                 
                                                                         