from PIL import Image
import os

# Dimensions cibles
TARGET_SIZE = (48, 48)

# Lister tous les fichiers dans le dossier courant
for filename in os.listdir("."):
    if filename.lower().endswith(".png"):
        try:
            with Image.open(filename) as img:
                resized_img = img.resize(TARGET_SIZE, Image.LANCZOS)
                resized_img.save(filename)
                print(f"{filename} redimensionné en 48x48.")
        except Exception as e:
            print(f"Erreur avec {filename} : {e}")